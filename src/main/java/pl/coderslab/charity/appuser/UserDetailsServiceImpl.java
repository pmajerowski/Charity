package pl.coderslab.charity.appuser;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserService appUserService;

    public UserDetailsServiceImpl(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = appUserService.findByEmail(email);


        AppUser appUser = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.getEnabled(),
                true,
                true,
                true,
                appUser.getRoles()
                );
    }

}
