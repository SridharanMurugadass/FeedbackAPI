package com.weeroda.feedback.service;

import com.weeroda.feedback.model.CustomUser;
import com.weeroda.feedback.model.Device;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.repository.UserRepo;
import com.weeroda.feedback.utils.HashingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo repo;

    @Autowired
    private DeviceService deviceService;

    public User create(User user) {
        LOGGER.debug("email: {}, mobile: {}", user.getEmail(), user.getMobile());
        user.setPassword(HashingService.encodeValue(user.getPassword()));
        user.setCreatedDate(new Date());

        User createdUser = repo.save(user);
        if (user.getDevices() != null) {
            user.getDevices().forEach(device -> device.setUserId(createdUser.get_id()));
            List<Device> createdDevices = deviceService.create(user.getDevices());
            createdUser.setDevices(createdDevices);
        }
        return createdUser;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = repo.findByUserId(userId);
        UserDetails userDetails = user == null ? null : new CustomUser(user);
        return userDetails;
    }
}
