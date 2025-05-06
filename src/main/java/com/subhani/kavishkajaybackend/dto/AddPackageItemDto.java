package com.subhani.kavishkajaybackend.dto;

import java.math.BigDecimal;

public class AddPackageItemDto {
    private Long itemId;

    private String name;

    private BigDecimal price;

    public AddPackageItemDto() {
    }

    public AddPackageItemDto(Long itemId, String name, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
