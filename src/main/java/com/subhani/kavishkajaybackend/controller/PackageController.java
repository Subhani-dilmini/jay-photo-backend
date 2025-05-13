package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.AdditionalItem;
import com.subhani.kavishkajaybackend.entity.PackageItem;
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


    @GetMapping("/additional-items")
    public ResponseEntity<List<CreateSessionDTO.ItemDto>> getAdditionalItems() {
        List<CreateSessionDTO.ItemDto> items = packageService.getAdditionalItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/additional-items")
    public ResponseEntity<AdditionalItem> addAdditionalItem(@RequestBody AddAdditionalItemDto additionalItem) {
        AdditionalItem newItem = packageService.addAdditionalItem(additionalItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }


    @PostMapping("/package-items")
    public ResponseEntity<PackageItem> addPackageItem(@RequestBody AddPackageItemDto packageItem) {
        PackageItem newItem = packageService.addPackageItem(packageItem);
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
