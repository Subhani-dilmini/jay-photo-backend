package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.AddPackageRequestDto;
import com.subhani.kavishkajaybackend.dto.UpdatePackageRequestDto;
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

    // ✅ Update Package
    @PutMapping
    public ResponseEntity<PhotographicPackage> updatePackage(@RequestBody UpdatePackageRequestDto request) {
        PhotographicPackage updatedPackage = packageService.updatePackage(request);
        return ResponseEntity.ok(updatedPackage);
    }

    // ✅ Get All Packages
    @GetMapping
    public ResponseEntity<List<PhotographicPackage>> getAllPackages() {
        System.out.println("test");
        return ResponseEntity.ok(packageService.getAllPackages());
    }

    // ✅ Delete Package
    @DeleteMapping("/{packageId}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long packageId) {
        packageService.deletePackage(packageId);
        return ResponseEntity.noContent().build();
    }
}
