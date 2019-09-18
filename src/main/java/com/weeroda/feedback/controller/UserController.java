package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.User;
import com.weeroda.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/v1")
    public User get() {
        return service.getLoggedInUser();
    }
}
