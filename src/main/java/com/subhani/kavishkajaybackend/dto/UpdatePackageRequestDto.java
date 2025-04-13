package com.subhani.kavishkajaybackend.dto;

import java.util.List;

//Updating a Package (Update DTO)
public class UpdatePackageRequestDto {

    private Long packageId;
    private String name;
    private Double price;
    private List<String> itemNames;  // Changed from itemIds to itemNames
    private List<Integer> quantities;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public UpdatePackageRequestDto() {
    }

    public UpdatePackageRequestDto(Long packageId, String name, Double price, List<Integer> quantities, List<String> itemNames) {
        this.packageId = packageId;
        this.name = name;
        this.price = price;
        this.quantities = quantities;
        this.itemNames = itemNames;
    }
}
