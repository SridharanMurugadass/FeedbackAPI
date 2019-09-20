package com.weeroda.feedback.service;

import com.weeroda.feedback.exception.AppException;
import com.weeroda.feedback.model.CustomUser;
import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.repository.UserRepo;
import com.weeroda.feedback.security.CurrentContext;
import com.weeroda.feedback.utils.HashingService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = repo.findByUserId(userId);
        UserDetails userDetails = user == null ? null : new CustomUser(user);
        return userDetails;
    }

    public User getLoggedInUser() {
        String loggedInUserId = CurrentContext.getUserId();
        User loggedInUser = getByUserId(loggedInUserId);
        loggedInUser.setPassword(null);
        return loggedInUser;
    }

    public User create(User user) {
        LOGGER.debug("email: {}, mobile: {}", user.getEmail(), user.getMobile());
        validate(user);
        user.getDevices().forEach(device -> {
            device.set_id(new ObjectId().toString());
            device.setCreatedDate(new Date());
        });
        user.setPassword(HashingService.encodeValue(user.getPassword()));
        user.setCreatedDate(new Date());
        User createdUser = repo.save(user);
        return createdUser;
    }

    public Device create(Device device) {
        validate(device);
        device.setCreatedDate(new Date());
        String deviceId = new ObjectId().toString();
        device.set_id(deviceId);
        User loggedInUser = getLoggedInUser();
        loggedInUser.getDevices().add(device);
        repo.save(loggedInUser);
        Device createdDevice = getLoggedInUser().getDevice(deviceId);
        return createdDevice;
    }

    private User getByUserId(String userId) {
        User user = repo.findByUserId(userId);
        return user;
    }

    private void validate(User user) {
        if (user.getUserId() == null || user.getUserId().trim().length() == 0) {
            throw new AppException("User Id is mandatory");
        }

        if (user.getPassword() == null || user.getPassword().trim().length() == 0) {
            throw new AppException("Password is mandatory");
        }

        User existingUser = repo.findByUserId(user.getUserId());
        if (existingUser != null) {
            throw new AppException("Duplicate User Id");
        }

        if (user.getDevices() != null) {
            user.getDevices().forEach(this::validate);
        }
    }

    private void validate(Device device) {
        if (device.getName() == null || device.getName().trim().length() == 0) {
            throw new AppException("Device Name is mandatory");
        }

        if (device.getLocation() == null || device.getLocation().trim().length() == 0) {
            throw new AppException("Device Location is mandatory");
        }
    }

    public boolean activateDevice(String userId, String deviceId) {
        boolean isAdmin = getLoggedInUser().isAdmin();
        if (! isAdmin) {
            throw new AppException("Unauthorized");
        }
        Optional<User> userOp = repo.findById(userId);
        User user = userOp.orElseThrow(() -> new AppException("Invalid User Id"));
        Device device = user.getDevice(deviceId);
        if (device == null) {
            throw new AppException("Invalid device");
        }
        device.setAccFlag(true);
        repo.save(user);
        return true;
    }
}
