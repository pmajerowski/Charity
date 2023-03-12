package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.dto.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("register")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserService appUserService;

    @GetMapping
    public String registerUser(Model model, HttpSession session) {
        if (session.getAttribute("userDTO") != null) {
            return "registration";
        }
        session.removeAttribute("userDTO");

        UserDTO userDTO = new UserDTO();
        model.addAttribute("userDTO", userDTO);
        session.setAttribute("userDTO", userDTO);

        return "registration";
    }

    @PostMapping
    public String register(@Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           Model model,
                           HttpSession session) {

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
            session.setAttribute("userDTO", userDTO);
            return "redirect:/register";
        }

        session.removeAttribute("userDTO");
        return registrationService.register(userDTO);
    }
}
