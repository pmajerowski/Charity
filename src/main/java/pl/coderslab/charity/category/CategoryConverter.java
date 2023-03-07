package pl.coderslab.charity.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String, Category> {
    private final CategoryService categoryService;

    @Autowired
    public CategoryConverter(CategoryService jpaBrewMethodService) {
        this.categoryService = jpaBrewMethodService;
    }

    @Override
    public Category convert(String source) {
        return categoryService.findById(Long.parseLong(source));
    }
}