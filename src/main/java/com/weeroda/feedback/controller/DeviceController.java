package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.security.CurrentContext;
import com.weeroda.feedback.service.DeviceService;
import com.weeroda.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    @Autowired
    private DeviceService service;

    @Autowired
    private UserService userService;

    @PostMapping("/v1")
    public Device create(@RequestBody Device device) {
        String loggedInUserId = CurrentContext.getUserId();
        User loggedInUser = userService.getByUserId(loggedInUserId);
        device.setUserId(loggedInUser.get_id());
        return service.create(device);
    }
}
