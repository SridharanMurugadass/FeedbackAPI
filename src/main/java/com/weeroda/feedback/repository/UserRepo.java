package com.weeroda.feedback.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.weeroda.feedback.model.User;

public interface UserRepo extends MongoRepository<User, String>  {

}
