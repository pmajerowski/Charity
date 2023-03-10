package pl.coderslab.charity.appuser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    public void saveUser(AppUser user) {
        appUserRepository.save(user);
    }

    public void deleteUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
