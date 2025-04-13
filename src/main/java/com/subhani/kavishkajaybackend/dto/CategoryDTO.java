package com.subhani.kavishkajaybackend.dto;

public class CategoryDTO {

    private Long id;

    private String categoryName;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryName, Long id) {
        this.categoryName = categoryName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
