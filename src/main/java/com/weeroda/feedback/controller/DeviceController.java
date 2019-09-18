package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.service.DeviceService;
import com.weeroda.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService service;

    @Autowired
    private UserService userService;

    @PostMapping("/v1")
    public Device create(@RequestBody Device device) {
        User loggedInUser = userService.getLoggedInUser();
        device.setUserId(loggedInUser.get_id());
        return service.create(device);
    }

    @GetMapping("/v1")
    public List<Device> getAll() {
        return service.getAll();
    }
}
