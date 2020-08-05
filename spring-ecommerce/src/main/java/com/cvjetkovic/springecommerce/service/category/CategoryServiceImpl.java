package com.cvjetkovic.springecommerce.service.category;

import com.cvjetkovic.springecommerce.exception.ResourceNotFoundException;
import com.cvjetkovic.springecommerce.model.category.Category;
import com.cvjetkovic.springecommerce.model.category.CategoryRequest;
import com.cvjetkovic.springecommerce.model.category.CategoryResponse;
import com.cvjetkovic.springecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Cvjetkovic
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @Override
//    public @NotNull List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }

    @Override
    public CategoryResponse getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<Category> returnValue = new ArrayList<>();
        CategoryResponse categoryResponse = new CategoryResponse();

        for (Category categoryFromRepo : categories) {
            Category category = new Category();
            category.setName(categoryFromRepo.getName());
            category.setSubcategories(categoryFromRepo.getSubcategories());
            category.setDescription(categoryFromRepo.getDescription());
            category.setCategoryId(categoryFromRepo.getCategoryId());
            returnValue.add(category);
        }

        categoryResponse.setCategories(returnValue);
        return categoryResponse;

    }

    @Override
    public Category getCategory(@Min(value = 1L, message = "Invalid category ID.") long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void insertWithQuery(CategoryRequest category) {
        categoryRepository.insertSubcategory(category.getDescription(), category.getName(), category.getParent_id());
    }

    @Override
    public Category update(Category category, Long id) {
        category.setCategoryId(id);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
