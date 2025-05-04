package com.subhani.kavishkajaybackend.entity;

import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;
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

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @NotNull //Java validation
    @Column(nullable = false, length = 225)
    private String event;

    @Enumerated(EnumType.STRING)
    private MeetingStatus meetingStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public Meeting() {
    }

    public @NotNull String getEvent() {
        return event;
    }

    public void setEvent(@NotNull String event) {
        this.event = event;
    }

    public @NotNull PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(@NotNull PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Meeting(int meetingId, String meetingMode, LocalDate date, LocalTime time, String place, User user, String event, MeetingStatus meetingStatus, PaymentStatus paymentStatus ) {
        this.meetingId = meetingId;
        this.meetingMode = meetingMode;
        this.date = date;
        this.time = time;
        this.place = place;
        this.meetingStatus = meetingStatus;
        this.user = user;
        this.event = event;
        this.paymentStatus = paymentStatus;
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

    public @NotNull MeetingStatus getStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(@NotNull MeetingStatus status) {
        this.meetingStatus = status;
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
                ", meetingStatus='" + meetingStatus + '\'' +
                ", user=" + user +
                '}';
    }

    // Enum for MeetingStatus


    // Enum for MeetingPaymentStatus
    public enum PaymentStatus {
        PENDING, PAID, FAILED
    }
}
