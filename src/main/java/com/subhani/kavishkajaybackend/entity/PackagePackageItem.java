package com.subhani.kavishkajaybackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "package_package_item")
public class PackagePackageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for the join table

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

    public PackagePackageItem(Long id, PhotographicPackage pkg, PackageItem item, int quantity) {
        this.id = id;
        this.pkg = pkg;
        this.item = item;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "PackagePackageItem{" +
                "id=" + id +
                ", pkg=" + pkg +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }


}
