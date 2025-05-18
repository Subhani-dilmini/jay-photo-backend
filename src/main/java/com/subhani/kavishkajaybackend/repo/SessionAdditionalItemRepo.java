package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.AdditionalItem;
import com.subhani.kavishkajaybackend.entity.SessionAdditionalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionAdditionalItemRepo extends JpaRepository<SessionAdditionalItem, Long> {
}
