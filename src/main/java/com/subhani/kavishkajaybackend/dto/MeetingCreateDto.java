package com.subhani.kavishkajaybackend.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingCreateDto {

    private int userId;
    private LocalDate date;
    private LocalTime time;
    private String meetingMode;
    private String event;
    private String place;

    public MeetingCreateDto() {
    }

    public MeetingCreateDto(int userId, LocalDate date, LocalTime time, String meetingMode, String place) {
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.meetingMode = meetingMode;
        this.place = place;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getMeetingMode() {
        return meetingMode;
    }

    public void setMeetingMode(String meetingMode) {
        this.meetingMode = meetingMode;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "MeetingCreateDto{" +
                "userId=" + userId +
                ", date=" + date +
                ", time=" + time +
                ", meetingMode='" + meetingMode + '\'' +
                ", event='" + event + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
