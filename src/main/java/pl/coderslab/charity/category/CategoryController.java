package pl.coderslab.charity.category;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/get/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.findById(categoryId);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @DeleteMapping(path = {"{categoryId}"})
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
