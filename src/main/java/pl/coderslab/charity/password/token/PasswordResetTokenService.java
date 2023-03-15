package pl.coderslab.charity.password.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public Optional<PasswordResetToken> getTokenByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }
}
