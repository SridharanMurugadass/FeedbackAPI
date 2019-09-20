package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/v1")
    public User get() {
        return service.getLoggedInUser();
    }

    @PostMapping("/devices/v1")
    public Device create(@RequestBody Device device) {
        return service.create(device);
    }

    @PutMapping("/{userId}/devices/{deviceId}/activate/v1")
    public boolean activateDevice(@PathVariable("userId") String userId, @PathVariable("deviceId") String deviceId) {
        return service.activateDevice(userId, deviceId);
    }
}
