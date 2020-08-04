
package com.cvjetkovic.springecommerce.service.category;


import com.cvjetkovic.springecommerce.model.category.Category;
import com.cvjetkovic.springecommerce.model.category.CategoryRequest;
import com.cvjetkovic.springecommerce.model.category.CategoryResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * @author Vladimir Cvjetkovic
 */
@Validated
public interface CategoryService {

    @NotNull List<Category> getAllCategories();

    Category getCategory(@Min(value = 1L, message = "Invalid category ID.") long id);

    Category save(Category category);

    Category update(Category category, Long id);

    void delete(Long id);

    CategoryResponse getCategoryResponse();

    void insertWithQuery(CategoryRequest category);
}

