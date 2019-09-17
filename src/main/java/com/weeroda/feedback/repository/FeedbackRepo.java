package com.weeroda.feedback.repository;

import com.weeroda.feedback.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepo extends MongoRepository<Feedback, String> {
}
