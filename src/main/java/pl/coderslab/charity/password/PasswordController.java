package pl.coderslab.charity.password;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.email.EmailBuilder;
import pl.coderslab.charity.email.EmailSender;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PasswordController {

    private final AppUserService appUserService;
    private final PasswordService passwordService;
    private final EmailSender emailSender;

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

        String token = UUID.randomUUID().toString();
        passwordService.createPasswordResetTokenForUser(user.get(), token);
        emailSender.send(
                user.get().getEmail(),
                "Charity - reset hasła",
                EmailBuilder.buildPasswordResetEmail(user.get(), token));

        return "pass-reset-confirmation";
    }

}
