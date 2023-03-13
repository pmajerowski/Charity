package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


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
