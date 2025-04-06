package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.*;

@Entity
public class SessionAdditionalItem {

    @EmbeddedId
    private SessionAdditionalItemId id;

    @ManyToOne
    @MapsId("sessionId")
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    private AdditionalItem item;

    private int quantity;
}
