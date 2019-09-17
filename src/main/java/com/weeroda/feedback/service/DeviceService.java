package com.weeroda.feedback.service;

import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.repository.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepo repo;

    public List<Device> create(List<Device> devices) {
        devices.forEach(device -> device.setCreatedDate(new Date()));
        List<Device> createdDevices = repo.saveAll(devices);
        return createdDevices;
    }

    public Device create(Device device) {
        device.setCreatedDate(new Date());
        Device createdDevice = repo.save(device);
        return createdDevice;
    }
}
