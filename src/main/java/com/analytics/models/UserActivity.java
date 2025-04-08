package com.analytics.models;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user_activity")
public class UserActivity {

    @Id
    private UUID id;

    @Column(name = "userId", nullable = false)
    private UUID userId;  // Just store the userId as a UUID instead of a User entity

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private Instant timestamp;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
