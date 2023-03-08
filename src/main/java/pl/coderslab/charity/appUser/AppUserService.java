package pl.coderslab.charity.appUser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser findUserById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

    public void saveUser(AppUser user) {
        appUserRepository.save(user);
    }

    public void deleteUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
