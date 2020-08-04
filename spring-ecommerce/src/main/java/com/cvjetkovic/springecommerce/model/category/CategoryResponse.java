package com.cvjetkovic.springecommerce.model.category;

import java.util.List;

/**
 * @author Vladimir Cvjetkovic
 */
public class CategoryResponse {

    List<Category> categories;

    public CategoryResponse() {
    }

    public CategoryResponse(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
