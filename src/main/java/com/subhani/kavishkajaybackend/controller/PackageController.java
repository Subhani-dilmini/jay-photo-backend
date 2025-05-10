package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.AddPackageItemDto;
import com.subhani.kavishkajaybackend.dto.AddPackageRequestDto;
import com.subhani.kavishkajaybackend.dto.UpdatePackageRequestDto;
import com.subhani.kavishkajaybackend.entity.AdditionalItem;
import com.subhani.kavishkajaybackend.entity.PhotographicPackage;
import com.subhani.kavishkajaybackend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    // ✅ Create Package
    @PostMapping
    public ResponseEntity<PhotographicPackage> addPackage(@RequestBody AddPackageRequestDto request) {
        PhotographicPackage newPackage = packageService.addPackage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPackage);
    }









    @PostMapping("/items")
    public ResponseEntity<AdditionalItem> addPackageItem(@RequestBody AddPackageItemDto additionalItem) {
        AdditionalItem newItem = packageService.addPackageItem(additionalItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }







    // ✅ Update Package
    @PutMapping
    public ResponseEntity<PhotographicPackage> updatePackage(@RequestBody UpdatePackageRequestDto request) {
        PhotographicPackage updatedPackage = packageService.updatePackage(request);
        return ResponseEntity.ok(updatedPackage);
    }


    // ✅ Delete Package
    @DeleteMapping("/{packageId}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long packageId) {
        packageService.deletePackage(packageId);
        return ResponseEntity.noContent().build();
    }


    // ✅ Get All Packages
    @GetMapping
    public ResponseEntity<List<PhotographicPackage>> getAllPackages() {
        System.out.println("test");
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    // ✅ Get All items
    @GetMapping("/availableItems")
    public ResponseEntity<List<AddPackageRequestDto.ItemDto>> getAllItems() {
        return ResponseEntity.ok(packageService.getAllItems());
    }
}
