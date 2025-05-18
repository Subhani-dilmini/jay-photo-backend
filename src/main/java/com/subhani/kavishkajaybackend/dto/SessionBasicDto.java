package com.subhani.kavishkajaybackend.dto;

import com.subhani.kavishkajaybackend.entity.AdditionalItem;
import com.subhani.kavishkajaybackend.entity.PhotographicPackage;
import com.subhani.kavishkajaybackend.entity.Session;
import com.subhani.kavishkajaybackend.enumeration.MeetingStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SessionBasicDto {
    private int sessionId;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private String event;
    private BigDecimal amount;
    private Session.SessionStatus sessionStatus;
    private Session.PaymentStatus paymentStatus;
    private PhotographicPackage aPackage;
    private List<AdditionalItem> additionalItems;
    private long userId;

    public SessionBasicDto() {
    }

    public SessionBasicDto(int sessionId, LocalDate date, LocalTime time, String place, String event, BigDecimal amount, Session.SessionStatus sessionStatus, Session.PaymentStatus paymentStatus, PhotographicPackage aPackage, List<AdditionalItem> additionalItems, long userId) {
        this.sessionId = sessionId;
        this.date = date;
        this.time = time;
        this.place = place;
        this.event = event;
        this.amount = amount;
        this.sessionStatus = sessionStatus;
        this.paymentStatus = paymentStatus;
        this.aPackage = aPackage;
        this.additionalItems = additionalItems;
        this.userId = userId;
        this.event = event;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Session.SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(Session.SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public Session.PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Session.PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PhotographicPackage getAPackage() {
        return aPackage;
    }

    public void setAPackage(PhotographicPackage aPackage) {
        this.aPackage = aPackage;
    }

    public List<AdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(List<AdditionalItem> additionalItems) {
        this.additionalItems = additionalItems;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public PhotographicPackage getaPackage() {
        return aPackage;
    }

    public void setaPackage(PhotographicPackage aPackage) {
        this.aPackage = aPackage;
    }
}
