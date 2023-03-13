package pl.coderslab.charity.password;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/pass_forgot")
@RequiredArgsConstructor
public class PasswordController {

    private final AppUserService appUserService;

    @GetMapping
    public String forgottenPassForm(HttpSession session) {
        return "pass-forgot";
    }

    @GetMapping("/email")
    public String sendPasswordForm(@RequestParam String email, HttpSession session) {
        Optional<AppUser> user = appUserService.findByEmail(email);
        if (user.isEmpty()) {
            session.setAttribute("no_email", "Nie istnieje konto powiązane z tym adresem email.");
            return "redirect:/pass_forgot";
        }
        session.removeAttribute("no_email");
//        TODO: Reset password, create new password form, send email
        return "redirect:/pass_forgot/pass-reset-confirmation";
    }

    @GetMapping("/pass-reset-confirmation")
    public String confirmPassResetEmail() {
        return "pass-reset-confirmation";
    }
}
