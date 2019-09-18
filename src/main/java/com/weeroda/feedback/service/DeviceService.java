package com.weeroda.feedback.service;

import com.weeroda.feedback.exception.AppException;
import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.repository.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepo repo;

    @Autowired
    private UserService userService;

    public List<Device> create(List<Device> devices) {
        devices.forEach(this::validate);
        devices.forEach(device -> device.setCreatedDate(new Date()));
        List<Device> createdDevices = repo.saveAll(devices);
        return createdDevices;
    }

    public Device create(Device device) {
        validate(device);
        device.setCreatedDate(new Date());
        Device createdDevice = repo.save(device);
        return createdDevice;
    }

    public List<Device> getAll() {
        User loggedInUser = userService.getLoggedInUser();
        List<Device> devices = repo.findByUserId(loggedInUser.get_id());
        return devices;
    }

    public void validate(Device device) {
        if (device.getName() == null || device.getName().trim().length() == 0) {
            throw new AppException("Device Name is mandatory");
        }

        if (device.getLocation() == null || device.getLocation().trim().length() == 0) {
            throw new AppException("Device Location is mandatory");
        }
    }
}
