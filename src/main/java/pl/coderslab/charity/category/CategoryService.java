package pl.coderslab.charity.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Category with given id does not exist");
        }
        categoryRepository.deleteById(id);
    }

}
