package pl.coderslab.charity.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private List<Category> categoryList;

    @BeforeEach
    void setUp() {
        categoryList = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Category 1");
        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Category 2");
        categoryList.add(category1);
        categoryList.add(category2);
    }

    @Test
    void getAllCategories_shouldReturnAllCategories() {
        // given
        when(categoryRepository.findAll()).thenReturn(categoryList);

        // when
        List<Category> actualCategoryList = categoryService.getAllCategories();

        // then
        assertEquals(categoryList, actualCategoryList);
    }

    @Test
    void findById_shouldReturnCorrectCategory() {
        // given
        Long categoryId = 1L;
        Category expectedCategory = new Category();
        expectedCategory.setId(categoryId);
        expectedCategory.setName("Category 1");
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(expectedCategory));

        // when
        Category actualCategory = categoryService.findById(categoryId);

        // then
        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    void findById_shouldReturnNullIfCategoryDoesNotExist() {
        // given
        Long categoryId = 1L;
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        // when
        Category actualCategory = categoryService.findById(categoryId);

        // then
        assertNull(actualCategory);
    }

    @Test
    void saveCategory_shouldSaveCategory() {
        // given
        Category category = new Category();

        // when
        categoryService.saveCategory(category);

        // then
        verify(categoryRepository, times(1)).save(category);
    }
}