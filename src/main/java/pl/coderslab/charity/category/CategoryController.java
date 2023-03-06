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
    public Category getCategoryById(@PathVariable Long categoryId) {
        return categoryService.findById(categoryId);
    }

}
