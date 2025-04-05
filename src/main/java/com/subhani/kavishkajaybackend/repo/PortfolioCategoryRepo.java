package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.PortfolioCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioCategoryRepo extends JpaRepository<PortfolioCategory, Long>
{
}
