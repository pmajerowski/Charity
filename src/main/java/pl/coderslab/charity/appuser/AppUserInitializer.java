package pl.coderslab.charity.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleRepository;


import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@DependsOn("roleInitializer")
public class AppUserInitializer {

    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner userCmdLineRunner(AppUserRepository appUserRepository) {
        if (appUserRepository.count() > 0) {
            return null;
        }
        return args -> {
            Set<Role> roleSetUser = roleRepository.findByName("ROLE_USER");
            Set<Role> roleSetAdmin = roleRepository.getAllBy();

            AppUser roleUser = new AppUser();
            roleUser.setEmail("test@charity_donation.com");
            roleUser.setPassword("$2a$04$YTzpKRrbxj4hhLg7fJ5ol.F0CBzreu.WJitw3mpvaNsQvOwj1Fma6");
            roleUser.setFirstName("User");
            roleUser.setEnabled(true);
            roleUser.setRoles(roleSetUser);

            AppUser roleAdmin = new AppUser();
            roleAdmin.setEmail("admin@charity_donation.com");
            roleAdmin.setPassword("$2a$04$Uz/M/RlnCJdz3qwO0rAMQO1lgQWoEduA.9q.76DR.eRXjrJxfqcDi");
            roleAdmin.setFirstName("Admin");
            roleAdmin.setEnabled(true);
            roleAdmin.setRoles(roleSetAdmin);

            appUserRepository.saveAll(List.of(roleUser, roleAdmin));

        };
    }
}
