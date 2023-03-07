package pl.coderslab.charity.institution;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InstitutionConfig {

    @Bean
    CommandLineRunner institutionCmdLineRunner(InstitutionRepository institutionRepository) {
        return args -> {
            Institution dbamOZdrowie =
                    new Institution(
                            "Fundacja \"Dbam o Zdrowie\"",
                            "Pomoc dzieciom z ubogich rodzin");
            Institution aKogo =
                    new Institution(
                            "Fundacja \"A kogo\"",
                            "Pomoc w wybudzaniu dzieci ze śpiączki");
            Institution dlaDzieci =
                    new Institution(
                            "Fundacja \"Dla dzieci\"",
                            "Pomoc osobom znajdującym się w trudnej sytuacji życiowej");
            Institution bezDomu =
                    new Institution(
                            "Fundacja \"Bez domu\"",
                            "Pomoc dla osób nie posiadających miejsca zamieszkania");
            Institution kazdyOddech =
                    new Institution(
                            "Fundacja \"Każdy oddech\"",
                            "Pomoc dla osób i dzieci przebywających w hospicjach");

            institutionRepository.saveAll(
                    List.of(dbamOZdrowie, aKogo, dlaDzieci, bezDomu, kazdyOddech)
            );
        };
    }
}