package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.CountDto;
import com.subhani.kavishkajaybackend.dto.MeetingBasicDto;
import com.subhani.kavishkajaybackend.dto.MeetingCreateDto;
import com.subhani.kavishkajaybackend.dto.MeetingUserDto;
import com.subhani.kavishkajaybackend.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingController {

    @Autowired
    private MeetingService service;

    // (1) count pending or confirmed
    @GetMapping("/count/pending-confirmed")
    public CountDto countPendingOrConfirmed() {
        return service.getPendingOrConfirmedCount();
    }

    // (2) get all upcoming
    @GetMapping("/upcoming")
    public List<MeetingBasicDto> getUpcomingMeetings() {
        return service.getUpcomingMeetings();
    }

    // (3) create new meeting
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MeetingCreateDto dto) {
        service.createMeeting(dto);
        return ResponseEntity.ok("Meeting created successfully");
    }

    // (4) count pending
    @GetMapping("/count/pending")
    public CountDto countPending() {
        return service.getPendingCount();
    }

    // (5) count confirmed
    @GetMapping("/count/confirmed")
    public CountDto countConfirmed() {
        return service.getConfirmedCount();
    }

    // (6) get pending with username
    @GetMapping("/pending")
    public List<MeetingUserDto> getPendingMeetingsWithUser() {
        return service.getPendingMeetingUsers();
    }

    // (7) get confirmed with username
    @GetMapping("/confirmed")
    public List<MeetingUserDto> getConfirmedMeetingsWithUser() {
        return service.getConfirmedMeetingUsers();
    }
}
