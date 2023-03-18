package pl.coderslab.charity.role;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class RoleInitializer {

    @Bean
    CommandLineRunner roleCmdLineRunner(RoleRepository roleRepository) {
        if (roleRepository.count() > 0) {
            return null;
        }
        return args -> {
            Role roleUser = new Role("ROLE_USER");
            Role roleAdmin = new Role("ROLE_ADMIN");

            roleRepository.saveAll(List.of(roleUser, roleAdmin));

        };
    }

}