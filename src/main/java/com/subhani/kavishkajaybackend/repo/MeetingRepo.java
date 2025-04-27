package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepo extends JpaRepository<Meeting,Long> {

    long countByStatus(String status);
    long countByStatusIn(List<String> statuses);
    List<Meeting> findByStatusIn(List<String> statuses);
    List<Meeting> findByStatus(String status);
}

