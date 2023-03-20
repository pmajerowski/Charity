package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("register")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserService appUserService;

    @GetMapping
    public String registerUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);

        return "registration";
    }

    @Transactional
    @PostMapping
    public String register(@Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           Model model
    ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    "err",
                    "BINDING RESULT WRONG");
            return "redirect:register";
        }

        if (appUserService.findByEmail(userDTO.getUsername()).isPresent()) {
            userDTO.setError(
                    "Istnieje już konto powiązane z tym adresem email"
            );
            model.addAttribute("userDTO", userDTO);
            return "registration";
        }
        userDTO.setError(null);

        return registrationService.register(userDTO);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "redirect:/login";
    }
}
