package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class AdditionalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private BigDecimal price;

    public AdditionalItem() {
    }

    public AdditionalItem(Long itemId, String name, BigDecimal price) {
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

    @Override
    public String toString() {
        return "AdditionalItem{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
