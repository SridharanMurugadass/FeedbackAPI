package com.weeroda.feedback.service;

import com.weeroda.feedback.model.Feedback;
import com.weeroda.feedback.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepo repo;

    @Autowired
    private SequenceService seqService;

    public Feedback create(Feedback feedback) {
        feedback.setCreatedDate(new Date());
        Feedback createdFeedback = repo.save(feedback);
        return createdFeedback;
    }
}
