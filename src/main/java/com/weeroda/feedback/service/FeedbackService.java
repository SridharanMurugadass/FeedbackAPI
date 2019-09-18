package com.weeroda.feedback.service;

import com.weeroda.feedback.exception.AppException;
import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.Feedback;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.model.UserMinimal;
import com.weeroda.feedback.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepo repo;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private UserService userService;

    public Feedback create(Feedback feedback) {
        validate(feedback);
        User loggedInUser = userService.getLoggedInUser();
        feedback.setUser(new UserMinimal(loggedInUser));
        feedback.setCreatedDate(new Date());
        Feedback createdFeedback = repo.save(feedback);
        return createdFeedback;
    }

    private void validate(Feedback feedback) {
        List<Device> devices = deviceService.getAll();
        String requestedDeviceId = feedback.getDeviceId();
        boolean isAllowedDevice = devices.stream().anyMatch(device -> device.get_id().equals(requestedDeviceId));
        if (!isAllowedDevice) {
            throw new AppException("Invalid Device");
        }
    }
}
