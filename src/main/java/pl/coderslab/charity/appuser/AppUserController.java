package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final PasswordEncoder passwordEncoder;

    private final AppUserService appUserService;

    @GetMapping("register")
    public String registerUser(Model model) {
        AppUser user = new AppUser();
        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("register")
    public String saveUser(AppUser user,
                           BindingResult bindingResult,
                           @RequestParam(name = "password2") String password2) {
        if (bindingResult.hasErrors()) {
            return null;
        }

        if (user.getPassword() != password2) {

        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        appUserService.saveUser(user);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
