package pl.coderslab.charity.password;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.email.EmailService;
import pl.coderslab.charity.password.token.PasswordResetToken;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class PasswordService {

    private final PasswordRepository passwordRepository;


    public void createPasswordResetTokenForUser(AppUser user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        resetToken.setExpiresAt(LocalDateTime.now().plusMinutes(30));
        passwordRepository.save(resetToken);
    }

}
