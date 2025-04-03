package com.subhani.kavishkajaybackend.dto;

//Fetching a Package (Response DTO)
// DTO for Package Items in Response:
public class PackageItemResponseDto {

    private String itemName;
    private int quantity;

    public PackageItemResponseDto() {
    }

    public PackageItemResponseDto(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
