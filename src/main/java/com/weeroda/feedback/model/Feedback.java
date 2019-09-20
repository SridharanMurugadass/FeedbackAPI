package com.weeroda.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback extends BaseEntity {
    private String _id;
    private int feedback;
    private DeviceMinimal device;
    private UserMinimal user;

    @Transient
    private String deviceId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    public DeviceMinimal getDevice() {
        return device;
    }

    @JsonIgnore
    public void setDevice(DeviceMinimal device) {
        this.device = device;
    }

    public UserMinimal getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(UserMinimal user) {
        this.user = user;
    }

    public String getDeviceId() {
        if (deviceId != null) { return deviceId; }
        return device == null ? null : device.getId();
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
