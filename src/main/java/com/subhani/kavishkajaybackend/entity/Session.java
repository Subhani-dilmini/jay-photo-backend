package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private BigDecimal amount;

    private LocalDate date;

    private LocalTime time;

    private String place;

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

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessionAdditionalItem> additionalItems = new ArrayList<>();;

    public Session() {
    }

    public Session(Long sessionId, BigDecimal amount, LocalDate date, LocalTime time, String place, SessionStatus sessionStatus, PaymentStatus paymentStatus, double payment, User user, PhotographicPackage aPackage, List<SessionAdditionalItem> additionalItems) {
        this.sessionId = sessionId;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.place = place;
        this.sessionStatus = sessionStatus;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
        this.user = user;
        this.aPackage = aPackage;
        this.additionalItems = additionalItems;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
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

    public List<SessionAdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    public void setAdditionalItems(List<SessionAdditionalItem> additionalItems) {
        this.additionalItems = additionalItems;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", amount=" + amount +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", payment='" + payment + '\'' +
                ", user=" + user +
                ", aPackage=" + aPackage +
                ", additionalItems=" + additionalItems +
                '}';
    }

    // Enum for SessionStatus
    public enum SessionStatus {
        PENDING, COMPLETED, CANCELED
    }

    // Enum for PaymentStatus
    public enum PaymentStatus {
        PENDING, PAID, FAILED
    }
}
