package com.weeroda.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Device extends BaseEntity {
    private String _id;
    private String name;
    private String macAddress;
    private String location;
    private String description;

    @JsonIgnore
    private boolean accFlag;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccFlag() {
        return accFlag;
    }

    public void setAccFlag(boolean accFlag) {
        this.accFlag = accFlag;
    }
}
