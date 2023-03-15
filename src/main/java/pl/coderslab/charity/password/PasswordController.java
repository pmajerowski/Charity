package pl.coderslab.charity.password;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.email.EmailBuilder;
import pl.coderslab.charity.email.EmailSender;
import pl.coderslab.charity.password.token.PasswordResetToken;
import pl.coderslab.charity.password.token.PasswordResetTokenService;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class PasswordController {

    private final AppUserService appUserService;
    private final PasswordService passwordService;
    private final EmailSender emailSender;
    private final PasswordResetTokenService passwordResetTokenService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/pass_forgot")
    public String forgottenPassForm() {
        return "pass-forgot";
    }

    @GetMapping("/pass_forgot/email")
    public String sendPasswordResetEmail(@RequestParam String email, Model model) {
        Optional<AppUser> user = appUserService.findByEmail(email);
        if (user.isEmpty()) {
            model.addAttribute(
                    "no_email",
                    "Nie istnieje konto powiązane z tym adresem email.");
            return "pass-forgot";
        }

        String token = UUID.randomUUID().toString();
        passwordService.createPasswordResetTokenForUser(user.get(), token);
        emailSender.send(
                user.get().getEmail(),
                "Charity - reset hasła",
                EmailBuilder.buildPasswordResetEmail(user.get(), token));

        return "pass-reset-confirmation";
    }


    @GetMapping("/pass-reset/confirm")
    public String confirmResetToken(
            @RequestParam(name = "token")String token,
            @RequestParam(name = "user_id")Long userId,
            Model model
    ) {

        PasswordResetToken tokenAssignedToUser = passwordResetTokenService
                .getTokenByToken(token)
                .orElseThrow(() -> new IllegalStateException("No such token"));

        AppUser appUser = appUserService.findById(userId).orElseThrow(
                ()-> new UsernameNotFoundException("No such user in existence"));


        if (!Objects.equals(userId, tokenAssignedToUser.getAppUser().getId()) || appUser == null) {
            return "redirect:/pass_forgot?error=error";
        }

        if (tokenAssignedToUser.getExpiresAt().isBefore(LocalDateTime.now())) {
            return "redirect:/pass_forgot?error=token_expired";
        }

        model.addAttribute("appUser", appUser);

        return "pass-reset-form";
    }

    @Transactional
    @PostMapping("/pass-reset-form")
    public String resetPassword(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserService.saveUser(appUser);
        return "/login";
    }

}
