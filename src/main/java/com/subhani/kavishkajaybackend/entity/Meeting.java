package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity //Jpa entity table
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meetingId;

    @NotNull //Java validation
    @Column(nullable = false, length = 100)
    private String meetingMode;

    @NotNull //Java validation
    @Column(nullable = false)
    private LocalDate date;

    @NotNull //Java validation
    @Column(nullable = false)
    private LocalTime time;

    @NotNull //Java validation
    @Column(nullable = false, length = 225)
    private String place;

    @NotNull //Java validation
    @Column(nullable = false, length = 100)
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Meeting() {
    }

    public Meeting(int meetingId, String meetingMode, LocalDate date, LocalTime time, String place, String status, User user) {
        this.meetingId = meetingId;
        this.meetingMode = meetingMode;
        this.date = date;
        this.time = time;
        this.place = place;
        this.status = status;
        this.user = user;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public @NotNull String getMeetingMode() {
        return meetingMode;
    }

    public void setMeetingMode(@NotNull String meetingMode) {
        this.meetingMode = meetingMode;
    }

    public @NotNull LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }

    public @NotNull LocalTime getTime() {
        return time;
    }

    public void setTime(@NotNull LocalTime time) {
        this.time = time;
    }

    public @NotNull String getPlace() {
        return place;
    }

    public void setPlace(@NotNull String place) {
        this.place = place;
    }

    public @NotNull String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingId=" + meetingId +
                ", meetingMode='" + meetingMode + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
