package pl.coderslab.charity.password.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    @Query("SELECT t FROM PasswordResetToken t WHERE t.appUser.id = ?1")
    Optional<PasswordResetToken> findByUserId(Long userId);

    Optional<PasswordResetToken> findByToken(String token);
}
