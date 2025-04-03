package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.PackageItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageItemRepo extends JpaRepository<PackageItem, Long> {
    Optional<PackageItem> findByName(String name);
}
