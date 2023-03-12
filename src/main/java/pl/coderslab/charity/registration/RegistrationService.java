package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.appuser.AppUserService;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleService;


import java.util.Set;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public String register(UserDTO request) {
        boolean isEmailValid = emailValidator.test(request.getUsername());
        if (!isEmailValid) {
            throw new IllegalStateException("email not valid");
        }

        AppUser appUser = new AppUser();
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setEmail(request.getUsername());
        appUser.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        Set<Role> roles = roleService.findRolesByName("ROLE_USER");
        appUser.setRoles(roles);

        appUser.setEnabled(false);

        return signUpUser(appUser);

    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserService.findByEmail(appUser.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("Email exists");
        }

        appUserService.saveUser(appUser);

        return "register-confirmation";
    }
}
