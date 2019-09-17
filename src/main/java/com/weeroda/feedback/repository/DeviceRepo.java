package com.weeroda.feedback.repository;

import com.weeroda.feedback.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepo extends MongoRepository<Device, String> {
}
