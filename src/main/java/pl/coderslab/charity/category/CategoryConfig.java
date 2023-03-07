package pl.coderslab.charity.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner categoryCmdLineRunner(CategoryRepository categoryRepository) {
        return args -> {
            Category clothesCategory = new Category("Ubrania");
            Category shoesCategory = new Category("Buty");
            Category toysCategory = new Category("Zabawki");
            Category booksCategory = new Category("Książki");
            Category kitchenCategory = new Category("Artykuły kuchenne");
            Category hygieneCategory = new Category("Kosmetyki");
            Category foodCategory = new Category("Żywność");
            Category otherCategory = new Category("Inne");

            categoryRepository.saveAll(
                    List.of(clothesCategory,
                            shoesCategory,
                            foodCategory,
                            toysCategory,
                            kitchenCategory,
                            booksCategory,
                            hygieneCategory,
                            otherCategory)
            );
        };
    }
}
