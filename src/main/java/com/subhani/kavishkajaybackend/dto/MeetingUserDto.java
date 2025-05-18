package com.subhani.kavishkajaybackend.dto;

import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingUserDto {
    private int id;
    private String meetingMode;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private String event;
    private MeetingStatus status;
    private String userName;

    public MeetingUserDto() {
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public MeetingStatus getMeetingStatus() {
        return status;
    }

    public void setMeetingStatus(MeetingStatus meetingStatus) {
        this.status = meetingStatus;
    }

    public MeetingUserDto(int id, String meetingMode, LocalDate date, LocalTime time, String place, String event, MeetingStatus status, String userName) {
        this.id = id;
        this.meetingMode = meetingMode;
        this.date = date;
        this.time = time;
        this.place = place;
        this.event = event;
        this.status = status;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public MeetingStatus getStatus() {
        return status;
    }

    public void setStatus(MeetingStatus status) {
        this.status = status;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MeetingUserDto{" +
                "id=" + id +
                ", meetingMode='" + meetingMode + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", event='" + event + '\'' +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }
}
