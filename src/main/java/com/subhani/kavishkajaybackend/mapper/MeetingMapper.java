package com.subhani.kavishkajaybackend.mapper;

import com.subhani.kavishkajaybackend.dto.CountDto;
import com.subhani.kavishkajaybackend.dto.MeetingBasicDto;
import com.subhani.kavishkajaybackend.dto.MeetingCreateDto;
import com.subhani.kavishkajaybackend.dto.MeetingUserDto;
import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.entity.User;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    // For endpoints 1, 4, 5
    default CountDto toCountDto(Long count) {
        CountDto dto = new CountDto();
        dto.setCount(count);
        return dto;
    }

    // For endpoint 2
    default MeetingBasicDto toMeetingBasicDto(Meeting meeting) {
        MeetingBasicDto dto = new MeetingBasicDto();
        dto.setMeetingId(meeting.getMeetingId());
        dto.setDate(meeting.getDate());
        dto.setTime(meeting.getTime());
        dto.setPlace(meeting.getPlace());
        dto.setMeetingStatus(meeting.getStatus());
        dto.setUserId(meeting.getUser().getId());
        return dto;
    }

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
