package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final PasswordEncoder passwordEncoder;

    private final AppUserService appUserService;

    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder;

    private final UserDetailsService userDetailsService;

    @GetMapping("register")
    public String registerUser(Model model) {
        AppUser user = new AppUser();
        model.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("register")
    public String saveUser(AppUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        appUserService.saveUser(user);
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        AppUser appUser = new AppUser();
        model.addAttribute("user", appUser);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") AppUser userCredentials, Model model) {
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        String encodedPassword = encoder.encode(password);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, encodedPassword);

        try {
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
