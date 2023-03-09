package pl.coderslab.charity.appUser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    @GetMapping("/login")
    public String login(Model model) {
        AppUser appUser = new AppUser();
        model.addAttribute("appUser", appUser);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {

        Optional<AppUser> userDetails = appUserService.findByEmail(email);
        if (userDetails.get() == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

        // Log in the user
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // Redirect the user to the home page
        return "redirect:/home";
    }
}
