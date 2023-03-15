package pl.coderslab.charity.password;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PasswordController {

    private final AppUserService appUserService;

    @GetMapping("/pass_forgot")
    public String forgottenPassForm() {
        return "pass-forgot";
    }

    @GetMapping("/pass_forgot/email")
    public String sendPasswordForm(@RequestParam String email, Model model) {
        Optional<AppUser> user = appUserService.findByEmail(email);
        if (user.isEmpty()) {
            model.addAttribute(
                    "no_email",
                    "Nie istnieje konto powiązane z tym adresem email.");
            return "pass-forgot";
        }

//        TODO: Reset password, create new password form, send email
        return "pass-reset-confirmation";
    }

}
