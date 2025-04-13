package com.subhani.kavishkajaybackend.dto;

import java.util.List;

//Adding a Package (Create DTO)
public class AddPackageRequestDto {

    private String name;
    private Double price;
    private List<String> itemNames; // Change itemIds → itemNames
    private List<Integer> quantities;

    public AddPackageRequestDto() {
    }

    public AddPackageRequestDto(String name, Double price, List<String> itemNames, List<Integer> quantities) {
        this.name = name;
        this.price = price;
        this.itemNames = itemNames;
        this.quantities = quantities;
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
}
