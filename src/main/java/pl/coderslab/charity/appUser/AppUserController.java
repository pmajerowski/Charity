package pl.coderslab.charity.appUser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("register")
    public String registerUser(Model model) {
        AppUser user = new AppUser();
        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("register")
    @ResponseBody
    public AppUser saveUser(AppUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        appUserService.saveUser(user);
        return user;
    }
}
