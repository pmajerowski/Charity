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
            Category clothesCategory = new Category("ubrania");
            Category shoesCategory = new Category("buty");
            Category toysCategory = new Category("zabawki");
            Category booksCategory = new Category("książki");
            Category kitchenCategory = new Category("artykuły kuchenne");
            Category hygieneCategory = new Category("kosmetyki");
            Category foodCategory = new Category("żywność");
            Category electronicsCategory = new Category("elektronika");
            Category otherCategory = new Category("inne");

            categoryRepository.saveAll(
                    List.of(clothesCategory,
                            shoesCategory,
                            foodCategory,
                            toysCategory,
                            booksCategory,
                            hygieneCategory,
                            kitchenCategory,
                            electronicsCategory,
                            otherCategory)
            );
        };
    }
}
