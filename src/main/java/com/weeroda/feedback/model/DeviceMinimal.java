package com.weeroda.feedback.model;

public class DeviceMinimal {
    private String id;
    private String name;
    private String location;

    public DeviceMinimal(Device device) {
        this.id = device.get_id();
        this.name = device.getName();
        this.location = device.getLocation();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
