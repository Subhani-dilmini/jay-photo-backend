package com.subhani.kavishkajaybackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "package")
public class PhotographicPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    private String name;
    private Double price;

    @OneToMany(mappedBy = "pkg", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<PackagePackageItem> packageItems = new ArrayList<>();


    public PhotographicPackage(Long packageId, String name, Double price, List<PackagePackageItem> packageItems) {
        this.packageId = packageId;
        this.name = name;
        this.price = price;
        this.packageItems = packageItems;
    }

    public PhotographicPackage() {
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

    public List<PackagePackageItem> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(List<PackagePackageItem> packageItems) {
        this.packageItems = packageItems;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", packageItems=" + packageItems +
                '}';
    }
}

