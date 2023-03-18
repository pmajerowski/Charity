package pl.coderslab.charity.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleService;


import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@DependsOn("roleInitializer")
public class AppUserInitializer {

    private final RoleService roleService;

    @Bean
    CommandLineRunner userCmdLineRunner(AppUserRepository appUserRepository) {
        if (appUserRepository.count() > 0) {
            return null;
        }
        return args -> {
            Set<Role> roleSetUser = roleService.findRolesByName("ROLE_USER");
            Set<Role> roleSetAdmin = roleService.findAllRoles();

            AppUser userUser = new AppUser();
            userUser.setEmail("test@charity_donation.com");
            userUser.setPassword("$2a$04$YTzpKRrbxj4hhLg7fJ5ol.F0CBzreu.WJitw3mpvaNsQvOwj1Fma6");
            userUser.setFirstName("User");
            userUser.setEnabled(true);
            userUser.setRoles(roleSetUser);

            AppUser userAdmin = new AppUser();
            userAdmin.setEmail("admin@charity_donation.com");
            userAdmin.setPassword("$2a$04$Uz/M/RlnCJdz3qwO0rAMQO1lgQWoEduA.9q.76DR.eRXjrJxfqcDi");
            userAdmin.setFirstName("Admin");
            userAdmin.setEnabled(true);
            userAdmin.setRoles(roleSetAdmin);

            appUserRepository.saveAll(List.of(userUser, userAdmin));

        };
    }
}
