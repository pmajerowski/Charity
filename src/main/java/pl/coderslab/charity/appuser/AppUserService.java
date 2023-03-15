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

    public Optional<AppUser> findById(Long userId) {
        return appUserRepository.findById(userId);
    }

    public void saveUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }


    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

}
