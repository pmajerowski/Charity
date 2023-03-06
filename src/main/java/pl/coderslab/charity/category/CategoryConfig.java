package pl.coderslab.charity.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository) {
        return args -> {
            Category clothesCategory = new Category("Clothes");
            Category furnitureCategory = new Category("Furniture");
            Category toysCategory = new Category("Toys");
            Category kitchenCategory = new Category("Kitchen");
            Category hygieneCategory = new Category("Hygiene");

            categoryRepository.saveAll(
                    List.of(clothesCategory,
                            furnitureCategory,
                            toysCategory,
                            kitchenCategory,
                            hygieneCategory)
            );
        };
    }
}
