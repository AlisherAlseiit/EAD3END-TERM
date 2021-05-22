package com.Alish.midka.Service;

import com.Alish.midka.model.Feedback;
import com.Alish.midka.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void leaveFeedback(Long productId, Long userId, String content) {

        Feedback feedback = new Feedback();

        feedback.setProductId(productId);
        feedback.setUserId(userId);
        feedback.setRating(content);

        feedbackRepository.saveAndFlush(feedback);

    }


    public void deleteFeedback(Long feedbackId) {

        feedbackRepository.deleteById(feedbackId);
    }
}
