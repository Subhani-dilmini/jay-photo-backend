package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "`Session`")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDate date;

    private LocalTime time;

    private String place;

    private String event;

    @Enumerated(EnumType.STRING)
    private SessionStatus sessionStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private double payment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false, referencedColumnName = "packageId")
    private PhotographicPackage aPackage;

    public Session() {
    }

    public Session(Long sessionId, BigDecimal amount, LocalDate date, LocalTime time, String place, SessionStatus sessionStatus, PaymentStatus paymentStatus, double payment, User user, PhotographicPackage aPackage, String event) {
        this.id = sessionId;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.place = place;
        this.sessionStatus = sessionStatus;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
        this.user = user;
        this.aPackage = aPackage;
        this.event = event;
    }

    public Long getSessionId() {
        return id;
    }

    public void setSessionId(Long sessionId) {
        this.id = sessionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public SessionStatus  getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(SessionStatus  sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public PaymentStatus  getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus  paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PhotographicPackage getaPackage() {
        return aPackage;
    }

    public void setaPackage(PhotographicPackage aPackage) {
        this.aPackage = aPackage;
    }


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", payment='" + payment + '\'' +
                ", user=" + user +
                ", aPackage=" + aPackage +
                '}';
    }

    // Enum for SessionStatus
    public enum SessionStatus {
        PENDING, CONFIRMED, COMPLETED, CANCELED
    }

    // Enum for PaymentStatus
    public enum PaymentStatus {
        PENDING, PAID, FAILED
    }
}