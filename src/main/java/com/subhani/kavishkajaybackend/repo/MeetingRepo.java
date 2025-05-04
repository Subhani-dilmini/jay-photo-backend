package com.subhani.kavishkajaybackend.repo;

import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepo extends JpaRepository<Meeting,Long> {

    long countByMeetingStatus(MeetingStatus status);
    long countByMeetingStatusIn(List<MeetingStatus> statuses);
    List<Meeting> findByMeetingStatusIn(List<MeetingStatus> statuses);
    List<Meeting> findByMeetingStatus(MeetingStatus status);
}

