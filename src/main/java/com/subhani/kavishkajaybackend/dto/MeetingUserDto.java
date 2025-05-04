package com.subhani.kavishkajaybackend.dto;

import com.subhani.kavishkajaybackend.entity.Meeting;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingUserDto {
    private int id;
    private String meetingMode;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private MeetingStatus status;
    private String userName;

    public MeetingUserDto() {
    }

    public MeetingUserDto(int id, String meetingMode, LocalDate date, LocalTime time, String place, MeetingStatus status, String userName) {
        this.id = id;
        this.meetingMode = meetingMode;
        this.date = date;
        this.time = time;
        this.place = place;
        this.status = status;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingMode() {
        return meetingMode;
    }

    public void setMeetingMode(String meetingMode) {
        this.meetingMode = meetingMode;
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

    public MeetingStatus getStatus() {
        return status;
    }

    public void setStatus(MeetingStatus status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MeetingUserDto{" +
                "meetingMode='" + meetingMode + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", status='" + status + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
