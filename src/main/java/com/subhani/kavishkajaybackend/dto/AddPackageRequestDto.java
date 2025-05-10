package com.subhani.kavishkajaybackend.dto;

import java.util.List;

public class AddPackageRequestDto {

    private String name;
    private Double price;
    private List<PackageItemDto> packageItems;

    public AddPackageRequestDto() {
    }

    public AddPackageRequestDto(String name, Double price, List<PackageItemDto> packageItems) {
        this.name = name;
        this.price = price;
        this.packageItems = packageItems;
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

    public List<PackageItemDto> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(List<PackageItemDto> packageItems) {
        this.packageItems = packageItems;
    }

    // Inner DTO class for package items
    public static class PackageItemDto {
        private ItemDto item;
        private int quantity;

        public PackageItemDto() {
        }

        public PackageItemDto(ItemDto item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public ItemDto getItem() {
            return item;
        }

        public void setItem(ItemDto item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // Inner DTO class for item details
    public static class ItemDto {
        private Long itemId;
        private String name;

        public ItemDto() {
        }

        public ItemDto(Long itemId, String name) {
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
}
