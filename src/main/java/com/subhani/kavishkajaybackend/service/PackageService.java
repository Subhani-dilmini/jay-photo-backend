package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.AddPackageItemDto;
import com.subhani.kavishkajaybackend.dto.AddPackageRequestDto;
import com.subhani.kavishkajaybackend.dto.PackageAvailableItemDto;
import com.subhani.kavishkajaybackend.dto.UpdatePackageRequestDto;
import com.subhani.kavishkajaybackend.entity.AdditionalItem;
import com.subhani.kavishkajaybackend.entity.PackageItem;
import com.subhani.kavishkajaybackend.entity.PackagePackageItem;
import com.subhani.kavishkajaybackend.entity.PhotographicPackage;
import com.subhani.kavishkajaybackend.mapper.PackageMapper;
import com.subhani.kavishkajaybackend.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    private final PackageMapper mapper;
    @Autowired
    private final PackageRepo packageRepository;

    @Autowired
    private final PackageItemRepo packageItemRepository;

    @Autowired
    private  final PackagePackageItemRepo packagePackageItemRepository;

    @Autowired
    private final AdditionalItemRepo additionalItemRepository;


    public PackageService(PackageMapper mapper, PackageRepo packageRepository, PackageItemRepo packageItemRepository, PackagePackageItemRepo packagePackageItemRepository, AdditionalItemRepo additionalItemRepository) {
        this.mapper = mapper;
        this.packageRepository = packageRepository;
        this.packageItemRepository = packageItemRepository;
        this.packagePackageItemRepository = packagePackageItemRepository;
        this.additionalItemRepository = additionalItemRepository;
    }


    // ✅ Add Package
    public PhotographicPackage addPackage(AddPackageRequestDto request) {
        PhotographicPackage newPackage = new PhotographicPackage();
        newPackage.setName(request.getName());
        newPackage.setPrice(request.getPrice());
        PhotographicPackage savedPackage = packageRepository.save(newPackage);

        for (int i = 0; i < request.getItemNames().size(); i++) {
            String itemName = request.getItemNames().get(i);
            int quantity = request.getQuantities().get(i);

            // Find or Create Item
            PackageItem item = packageItemRepository.findByName(itemName)
                    .orElseGet(() -> packageItemRepository.save(new PackageItem(itemName)));

            // Create PackagePackageItem relationship
            PackagePackageItem packageItem = new PackagePackageItem();
            packageItem.setPkg(savedPackage);
            packageItem.setItem(item);
            packageItem.setQuantity(quantity);

            packagePackageItemRepository.save(packageItem);
        }

        return savedPackage;
    }

    // ✅ Add Package item
    public AdditionalItem addPackageItem(AddPackageItemDto additionalItem) {
        AdditionalItem newPackage = new AdditionalItem();
        newPackage.setName(additionalItem.getName());
        newPackage.setPrice(additionalItem.getPrice());
        AdditionalItem savedPackage;
        savedPackage = additionalItemRepository.save(newPackage);
        return savedPackage;
    }

    // ✅ Update Package
    public PhotographicPackage updatePackage(UpdatePackageRequestDto request) {
        PhotographicPackage existingPackage = packageRepository.findById(request.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        existingPackage.setName(request.getName());
        existingPackage.setPrice(request.getPrice());
        packagePackageItemRepository.deleteAll(existingPackage.getPackageItems()); // Remove old items

        for (int i = 0; i < request.getItemNames().size(); i++) {
            String itemName = request.getItemNames().get(i);
            int quantity = request.getQuantities().get(i);

            PackageItem item = packageItemRepository.findByName(itemName)
                    .orElseGet(() -> packageItemRepository.save(new PackageItem(itemName)));

            PackagePackageItem packageItem = new PackagePackageItem();
            packageItem.setPkg(existingPackage);
            packageItem.setItem(item);
            packageItem.setQuantity(quantity);

            packagePackageItemRepository.save(packageItem);
        }

        return packageRepository.save(existingPackage);
    }

    // ✅ Get All Packages
    public List<PhotographicPackage> getAllPackages() {

        return packageRepository.findAll();
    }

    // ✅ Delete Package
    public void deletePackage(Long packageId) {

        packageRepository.deleteById(packageId);
    }

    public List<PackageAvailableItemDto> getAllItems() {

        List<PackageItem> items = packageItemRepository.findAll();
        return mapper.toDtoList(items);

    }
}
