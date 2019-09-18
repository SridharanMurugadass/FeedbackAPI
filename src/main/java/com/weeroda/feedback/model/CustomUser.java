package com.weeroda.feedback.model;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class CustomUser extends User {
    public CustomUser(com.weeroda.feedback.model.User user) {
        super(user.getUserId(), user.getPassword(), Collections.emptyList());
    }
}
