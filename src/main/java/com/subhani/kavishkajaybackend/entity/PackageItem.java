package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "package_item")
public class PackageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PackagePackageItem> packagePackageItems = new ArrayList<>();

    public PackageItem(String itemName) {
    }

    public PackageItem(Long itemId, String name, List<PackagePackageItem> packagePackageItems) {
        this.itemId = itemId;
        this.name = name;
        this.packagePackageItems = packagePackageItems;
    }

    public PackageItem() {

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

    public List<PackagePackageItem> getPackagePackageItems() {
        return packagePackageItems;
    }

    public void setPackagePackageItems(List<PackagePackageItem> packagePackageItems) {
        this.packagePackageItems = packagePackageItems;
    }

    @Override
    public String toString() {
        return "PackageItem{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", packagePackageItems=" + packagePackageItems +
                '}';
    }
}
