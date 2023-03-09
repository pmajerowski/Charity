package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final PasswordEncoder passwordEncoder;

    private final AppUserService appUserService;

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
    public String login(AppUser user, BindingResult bindingResult) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
//
//        if (userDetails == null) {
//            // handle invalid username
//            System.out.println("ee mordo");
//        }
//
//        // Use the password encoder to check if the password is correct
//        if (!passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
//            System.out.println("ee mordoooooo");        }
//
//        // Set the authenticated user in the security context
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return "/";
    }
}
