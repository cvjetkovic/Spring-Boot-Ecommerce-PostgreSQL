package com.cvjetkovic.springecommerce.model.category;
/**
 * @author Vladimir Cvjetkovic
 */
public class CategoryRequest {

    private String name;
    private String description;
    private Long parent_id;

    public CategoryRequest() {
    }

    public CategoryRequest(String name, String description, Long parent_id) {
        this.name = name;
        this.description = description;
        this.parent_id = parent_id;
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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}
