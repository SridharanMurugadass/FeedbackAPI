package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.service.DeviceService;
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

    @PostMapping("/v1")
    public Device create(@RequestBody Device device) {
        return service.create(device);
    }
}
