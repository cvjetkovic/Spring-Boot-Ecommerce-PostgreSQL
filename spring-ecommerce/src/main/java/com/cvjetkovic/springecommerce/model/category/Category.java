package com.cvjetkovic.springecommerce.model.category;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vladimir Cvjetkovic
 */
@Entity
@Table(name = "categories", schema = "public")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "parent_id", referencedColumnName = "category_id")
    private List<Category> subcategories;

    public Category() {
    }

    public Category(Long categoryId, String name, String description, List<Category> subcategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.subcategories = subcategories;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }
}
