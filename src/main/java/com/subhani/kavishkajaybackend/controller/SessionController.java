package com.subhani.kavishkajaybackend.controller;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import com.subhani.kavishkajaybackend.service.MeetingService;
import com.subhani.kavishkajaybackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService service;

    // (3) create new session
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSessionDTO dto) {
        service.addSession(dto);
        return ResponseEntity.ok("Session created successfully");
    }

    @GetMapping("/upcomingCountByUser/{id}")
    public CountDto getUpcomingCountByUser(@PathVariable("id") Integer id) {
        return service.getUpcomingCountByUser(id);
    }

    @GetMapping("/upcomingByUser/{id}")
    public List<SessionBasicDto> getUpcomingSessionsByUser(@PathVariable("id") Integer id) {
        return service.getUpcomingSessionsByUser(id);
    }

    @GetMapping("/pastCountByUser/{id}")
    public CountDto getPastCountByUser(@PathVariable("id") Integer id) {
        return service.getPastCountByUser(id);
    }

    @GetMapping("/pastByUser/{id}")
    public List<SessionBasicDto> getPastSessionsByUser(@PathVariable("id") Integer id) {
        return service.getPastSessionsByUser(id);
    }
}
