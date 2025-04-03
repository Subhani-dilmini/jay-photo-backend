package com.subhani.kavishkajaybackend.dto;

import java.util.List;

//Fetching a Package (Response DTO)
//DTO for Fetching a Package
public class PackageResponseDto {

    private Long packageId;
    private String name;
    private Double price;
    private List<PackageItemResponseDto> items;

    public PackageResponseDto() {
    }

    public PackageResponseDto(Long packageId, String name, Double price, List<PackageItemResponseDto> items) {
        this.packageId = packageId;
        this.name = name;
        this.price = price;
        this.items = items;
    }

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

    public List<PackageItemResponseDto> getItems() {
        return items;
    }

    public void setItems(List<PackageItemResponseDto> items) {
        this.items = items;
    }
}
