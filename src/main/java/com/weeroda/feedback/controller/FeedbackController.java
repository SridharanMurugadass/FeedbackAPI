package com.weeroda.feedback.controller;

import com.weeroda.feedback.model.Feedback;
import com.weeroda.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @PostMapping("/v1")
    public Feedback create(@RequestBody Feedback feedback) {
        return service.create(feedback);
    }
}
