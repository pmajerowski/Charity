package pl.coderslab.charity.password;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.email.EmailService;
import pl.coderslab.charity.password.token.PasswordResetToken;


@Service
@AllArgsConstructor
public class PasswordService {
    private final EmailService emailService;
    private final PasswordRepository passwordRepository;


    public void createPasswordResetTokenForUser(AppUser user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordRepository.save(resetToken);
    }

}
