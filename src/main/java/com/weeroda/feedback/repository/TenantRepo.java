package com.weeroda.feedback.repository;

import com.weeroda.feedback.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TenantRepo extends MongoRepository<User, String> {

}
