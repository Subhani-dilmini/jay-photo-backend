package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

@Entity
public class SessionAdditionalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private AdditionalItem item;

    private int quantity;
}
