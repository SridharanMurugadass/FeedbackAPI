package com.weeroda.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback extends BaseEntity {
    private int feedback;
    private String deviceId;
    private UserMinimal user;

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public UserMinimal getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(UserMinimal user) {
        this.user = user;
    }
}
