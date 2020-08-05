package com.cvjetkovic.springecommerce.controller.category;

import com.cvjetkovic.springecommerce.model.category.Category;
import com.cvjetkovic.springecommerce.model.category.CategoryRequest;
import com.cvjetkovic.springecommerce.model.category.CategoryResponse;
import com.cvjetkovic.springecommerce.service.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vladimir Cvjetkovic
 */
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {

    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping(value = {"", "/"})
//    public @NotNull Iterable<Category> getCategories() {
//        return categoryService.getAllCategories();
//    }

    @GetMapping(value = {"", "/"})
    public CategoryResponse getCategories1() {
        return categoryService.getCategoryResponse();
    }

    @PostMapping(value = "/cat")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }

    @PostMapping(value = "/sub")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryRequest createSubcategory(@RequestBody CategoryRequest category) {
        categoryService.insertWithQuery(category);
        return category;
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.update(category, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
