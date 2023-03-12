package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.registration.token.ConfirmationToken;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public void saveUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    public void deleteUserById(Long id) {
        appUserRepository.deleteById(id);
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
