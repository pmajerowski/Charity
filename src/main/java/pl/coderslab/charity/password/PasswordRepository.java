package pl.coderslab.charity.password;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.password.token.PasswordResetToken;

public interface PasswordRepository extends JpaRepository<PasswordResetToken, Long> {
}
