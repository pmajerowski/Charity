package pl.coderslab.charity.donation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DonationConfig {

    @Bean
    CommandLineRunner donationCmdLineRunner(DonationRepository donationRepository) {
        return args -> {
            Donation first = new Donation(1L, 10, "Marszałkowska 135", "Warsaw", "00-410");
            Donation second = new Donation(2L, 4, "456 HossfundStrasse", "Berlin", "18745");
            Donation third = new Donation(3L, 7, "32 Baker St", "London", "00981");

            donationRepository.saveAll(List.of(first, second, third));

        };
    }

}
