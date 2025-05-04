package com.subhani.kavishkajaybackend.service;

import com.subhani.kavishkajaybackend.dto.CountDto;
import com.subhani.kavishkajaybackend.dto.MeetingBasicDto;
import com.subhani.kavishkajaybackend.dto.MeetingCreateDto;
import com.subhani.kavishkajaybackend.dto.MeetingUserDto;
import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import com.subhani.kavishkajaybackend.mapper.MeetingMapper;
import com.subhani.kavishkajaybackend.repo.MeetingRepo;
import com.subhani.kavishkajaybackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MeetingMapper meetingMapper;

    // Endpoint 1: count pending/confirmed
    public CountDto getPendingOrConfirmedCount() {
        Long count = meetingRepo.countByMeetingStatusIn(List.of(MeetingStatus.PENDING, MeetingStatus.CONFIRMED));
        return meetingMapper.toCountDto(count);
    }

    // Endpoint 2: get all upcoming
    public List<MeetingBasicDto> getUpcomingMeetings() {
        return meetingRepo.findByMeetingStatusIn(List.of(MeetingStatus.PENDING, MeetingStatus.CONFIRMED))
                .stream().map(meetingMapper::toMeetingBasicDto).toList();
    }

    // Endpoint 3: create new meeting
    public void createMeeting(MeetingCreateDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Meeting meeting = meetingMapper.toMeeting(dto, user);
        meetingRepo.save(meeting);
    }

    // Endpoint 4: count pending only
    public CountDto getPendingCount() {
        return meetingMapper.toCountDto(meetingRepo.countByMeetingStatus(MeetingStatus.PENDING));
    }

    // Endpoint 5: count confirmed only
    public CountDto getConfirmedCount() {
        return meetingMapper.toCountDto(meetingRepo.countByMeetingStatus(MeetingStatus.CONFIRMED));
    }

    // Endpoint 6: pending meetings + userName
    public List<MeetingUserDto> getPendingMeetingUsers() {
        return meetingRepo.findByMeetingStatus(MeetingStatus.PENDING)
                .stream().map(meetingMapper::toMeetingUserDto).toList();
    }

    // Endpoint 7: confirmed meetings + userName
    public List<MeetingUserDto> getConfirmedMeetingUsers() {
        return meetingRepo.findByMeetingStatus(MeetingStatus.CONFIRMED)
                .stream().map(meetingMapper::toMeetingUserDto).toList();
    }

    // Endpoint 8: change status
    public Meeting changeMeetingStatus(MeetingStatus status, Long id) {
        Meeting meeting = meetingRepo.findById(id).orElseThrow();
        meeting.setMeetingStatus(status);

        return meetingRepo.save(meeting);
    }
}
