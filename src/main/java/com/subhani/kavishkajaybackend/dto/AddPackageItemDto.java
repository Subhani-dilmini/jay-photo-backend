package com.subhani.kavishkajaybackend.dto;

import java.math.BigDecimal;

public class AddPackageItemDto {
    private Long itemId;

    private String name;

    public AddPackageItemDto() {
    }

    public AddPackageItemDto(Long itemId, String name) {
        this.itemId = itemId;
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
