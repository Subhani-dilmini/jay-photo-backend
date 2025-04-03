package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.PhotographicPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo extends JpaRepository<PhotographicPackage, Long> {
}
