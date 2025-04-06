package com.subhani.kavishkajaybackend.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessionAdditionalItemId implements Serializable {

    private Long sessionId;
    private Long itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionAdditionalItemId that = (SessionAdditionalItemId) o;
        return Objects.equals(sessionId, that.sessionId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, itemId);
    }

    public SessionAdditionalItemId() {
    }

    public SessionAdditionalItemId(Long sessionId, Long itemId) {
        this.sessionId = sessionId;
        this.itemId = itemId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


}
