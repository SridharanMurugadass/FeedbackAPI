package com.weeroda.feedback.service;

import com.weeroda.feedback.exception.AppException;
import com.weeroda.feedback.model.*;
import com.weeroda.feedback.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepo repo;

    @Autowired
    private UserService userService;

    public Feedback create(Feedback feedback) {
        User loggedInUser = userService.getLoggedInUser();
        Device device = loggedInUser.getDevice(feedback.getDeviceId());
        if (device == null || !device.isAccFlag()) {
            throw new AppException("Invalid Device");
        }

        feedback.setDevice(new DeviceMinimal(device));
        feedback.setUser(new UserMinimal(loggedInUser));
        feedback.setCreatedDate(new Date());
        Feedback createdFeedback = repo.save(feedback);
        return createdFeedback;
    }
}
