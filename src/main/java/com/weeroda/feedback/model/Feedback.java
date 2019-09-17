package com.weeroda.feedback.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback extends BaseEntity {
    private int feedback;
    private String deviceId;
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
