package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.*;
import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.entity.Session;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    // For endpoints 1, 4, 5
    default CountDto toCountDto(Long count) {
        CountDto dto = new CountDto();
        dto.setCount(count);
        return dto;
    }

    // For endpoint 2
    List<SessionBasicDto> toSessionBasicDTOList(List<Session> session);

    // For endpoint 6, 7
    default MeetingUserDto toMeetingUserDto(Meeting meeting) {
        MeetingUserDto dto = new MeetingUserDto();
        dto.setId(meeting.getMeetingId());
        dto.setMeetingMode(meeting.getMeetingMode());
        dto.setDate(meeting.getDate());
        dto.setTime(meeting.getTime());
        dto.setPlace(meeting.getPlace());
        dto.setStatus(meeting.getStatus());
        dto.setUserName(meeting.getUser().getUsername());
        return dto;
    }

    // For endpoint 3 - create new Meeting
    default Meeting toMeeting(MeetingCreateDto dto, User user) {
        Meeting meeting = new Meeting();
        meeting.setDate(dto.getDate());
        meeting.setTime(dto.getTime());
        meeting.setMeetingMode(dto.getMeetingMode());
        meeting.setPlace(dto.getPlace());
        meeting.setEvent(dto.getEvent());
        meeting.setMeetingStatus(MeetingStatus.PENDING);
        meeting.setPaymentStatus(Meeting.PaymentStatus.PENDING);// default
        meeting.setUser(user);
        return meeting;
    }
}
