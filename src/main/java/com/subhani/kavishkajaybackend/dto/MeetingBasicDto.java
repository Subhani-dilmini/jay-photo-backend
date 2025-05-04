package com.subhani.kavishkajaybackend.dto;

import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingBasicDto {
    private int meetingId;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private MeetingStatus meetingStatus;
    private long userId;

    public MeetingBasicDto() {
    }

    public MeetingBasicDto(int meetingId, LocalDate date, LocalTime time, String place, MeetingStatus meetingStatus, Long userId) {
        this.meetingId = meetingId;
        this.date = date;
        this.time = time;
        this.place = place;
        this.meetingStatus = meetingStatus;
        this.userId = userId;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public MeetingStatus getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(MeetingStatus status) {
        this.meetingStatus = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MeetingBasicDto{" +
                "meetingId=" + meetingId +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", meetingStatus='" + meetingStatus + '\'' +
                ", userId=" + userId +
                '}';
    }
}
