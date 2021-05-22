package com.Alish.midka.controller;

import com.Alish.midka.Service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;



    @PostMapping("/leaveFeedback")
    public void leaveFeedback(@RequestParam Long productId, Long userId, String feedback){

        feedbackService.leaveFeedback(productId, userId, feedback);
    }

    @DeleteMapping("/{feedbackId}")
    public void deleteFeedback(@RequestParam Long feedbackId) {
        feedbackService.deleteFeedback(feedbackId);
    }


}
