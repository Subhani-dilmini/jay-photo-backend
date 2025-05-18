package com.subhani.kavishkajaybackend.dto;

public class CreateCategoryDTO {
    private String categoryName;

    public CreateCategoryDTO() {
    }

    public CreateCategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
