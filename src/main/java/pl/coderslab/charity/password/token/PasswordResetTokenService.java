package pl.coderslab.charity.password.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.password.PasswordService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public Optional<PasswordResetToken> getTokenByUserId(Long userId) {
        return passwordResetTokenRepository.findByUserId(userId);
    }

    public Optional<PasswordResetToken> getTokenByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }
}
