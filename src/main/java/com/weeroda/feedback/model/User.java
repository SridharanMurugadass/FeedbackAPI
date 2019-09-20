package com.weeroda.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "fbsUser")
public class User extends BaseEntity {
    private String _id;
    private String userId;
    private String mobile;
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    @JsonIgnore
    private boolean paymentDone;

    private List<Device> devices;

    @JsonIgnore
    private boolean admin;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }

    public List<Device> getDevices() {
        return devices != null ? devices : new ArrayList<>(0);
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Device getDevice(String deviceId) {
        for (Device device : getDevices()) {
            if (device.get_id().equals(deviceId)) {
                return device;
            }
        }
        return null;
    }
}
