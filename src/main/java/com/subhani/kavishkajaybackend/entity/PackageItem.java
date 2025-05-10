package com.subhani.kavishkajaybackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private List<PackagePackageItem> packagePackageItems = new ArrayList<>();

    public PackageItem() {
    }

    public PackageItem(String name) {
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

    public List<PackagePackageItem> getPackagePackageItems() {
        return packagePackageItems;
    }

    public void setPackagePackageItems(List<PackagePackageItem> packagePackageItems) {
        this.packagePackageItems = packagePackageItems;
    }
}
