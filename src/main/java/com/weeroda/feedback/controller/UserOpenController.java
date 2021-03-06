package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.User;
import com.weeroda.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open/users")
public class UserOpenController {
    @Autowired
    private UserService service;

    @PostMapping("/v1")
    public User signUp(@RequestBody User user) {
        return service.create(user);
    }
}
