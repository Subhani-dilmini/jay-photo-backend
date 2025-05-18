package com.subhani.kavishkajaybackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "package_package_item")
public class PackagePackageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    @JsonBackReference
    private PhotographicPackage pkg;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    @JsonManagedReference
    private PackageItem item;

    private int quantity;

    public PackagePackageItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhotographicPackage getPkg() {
        return pkg;
    }

    public void setPkg(PhotographicPackage pkg) {
        this.pkg = pkg;
    }

    public PackageItem getItem() {
        return item;
    }

    public void setItem(PackageItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
