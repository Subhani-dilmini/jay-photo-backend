package com.subhani.kavishkajaybackend.dto;

import com.subhani.kavishkajaybackend.entity.AdditionalItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CreateSessionDTO {
    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private double payment;
    private Integer userId;
    private PackageDTO photographyPackage;
    private List<AdditionalItemDto> additionalItems;

    public CreateSessionDTO(Long id, BigDecimal amount, LocalDate date, LocalTime time, String place, double payment, Integer userId, PackageDTO photographyPackage, List<AdditionalItemDto> additionalItems) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.place = place;
        this.payment = payment;
        this.userId = userId;
        this.photographyPackage = photographyPackage;
        this.additionalItems = additionalItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PackageDTO getPhotographyPackage() {
        return photographyPackage;
    }

    public void setPhotographyPackage(PackageDTO photographyPackage) {
        this.photographyPackage = photographyPackage;
    }

    public List<AdditionalItemDto> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(List<AdditionalItemDto> additionalItems) {
        this.additionalItems = additionalItems;
    }

    // Inner DTO class for item details
    public static class PackageDTO {
        private Long packageId;
        private String name;

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
    }

    // Inner DTO class for package items
    public static class AdditionalItemDto {
        private ItemDto item;
        private int quantity;

        public AdditionalItemDto() {
        }

        public AdditionalItemDto(ItemDto item, int quantity) {
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
        private BigDecimal price;

        public ItemDto() {
        }

        public ItemDto(Long itemId, String name, BigDecimal price) {
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
}
