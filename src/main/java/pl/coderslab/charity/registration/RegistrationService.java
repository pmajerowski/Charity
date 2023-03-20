package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.email.CredentialsConfiguration;
import pl.coderslab.charity.email.EmailSender;
import pl.coderslab.charity.registration.token.ConfirmationToken;
import pl.coderslab.charity.registration.token.ConfirmationTokenService;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleService;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static pl.coderslab.charity.email.EmailBuilder.*;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSender emailSender;
    private final CredentialsConfiguration credentialsConfiguration;

    public String register(UserDTO request) {
        boolean isEmailValid = emailValidator.test(request.getUsername());
        if (!isEmailValid) {
            throw new IllegalStateException("email not valid");
        }

        AppUser appUser = new AppUser();
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setEmail(request.getUsername());
        appUser.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        Set<Role> roles = roleService.findRolesByName("ROLE_USER");
        appUser.setRoles(roles);

        if (credentialsConfiguration.areCredentialsConfigured()) {
            appUser.setEnabled(false);
            String token = signUpUser(appUser);

            String link = "http://localhost:8080/register/confirm?token=" + token;

            emailSender.send(
                    request.getUsername(),
                    "Charity - potwierdzenie rejestracji",
                    buildAccountActivationEmail(request.getFirstName(), link));
        } else {
            appUser.setEnabled(true);
            signUpUser(appUser);
        }

        return "register-confirmation";

    }

    @Transactional
    public void confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserService
                .findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {

            throw new IllegalStateException("Email exists");
        }

        appUserService.saveUser(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }
}
