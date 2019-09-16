package com.weeroda.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weeroda.feedback.dao.UserDao;
import com.weeroda.feedback.model.User;
import com.weeroda.feedback.repository.UserRepo;
import com.weeroda.feedback.utils.HashingService;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FeedbackController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	UserRepo repo;

	@Autowired
	UserDao dao;

	@CrossOrigin
	@PostMapping("/signUp")
	public User signUp(@RequestBody User user) {

		LOGGER.debug("email: {}, mobile: {}", user.getEmail(), user.getMobile());

		user.setPassword(HashingService.encodeValue(user.getPassword()));

		Date date = new Date();

		user.setCreatedDate(date);

		return repo.save(user);// registration success

	}

}
