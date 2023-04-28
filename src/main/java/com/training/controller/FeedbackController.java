package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.FeedbackDTO;
import com.training.repository.FeedbackRepository;
import com.training.servcie.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @PostMapping(value = ApiPath.FEEDBACK_CREATE)
    public FeedbackDTO newFeedback(@RequestBody FeedbackDTO newFeedback) {
        return service.save(newFeedback);
    }

    @GetMapping(value = ApiPath.FEEDBACK_GET_ALL)
    public List<FeedbackDTO> getAllFeedbacks() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.FEEDBACK_BY_ID)
    public FeedbackDTO getFeedbackById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.FEEDBACK_UPDATE)
    public Integer updateFeedback(@RequestBody FeedbackDTO newFeedback) {
        return service.update(newFeedback);
    }

    @DeleteMapping(value = ApiPath.FEEDBACK_DELETE)
    public String deleteFeedback(@RequestBody FeedbackDTO newFeedback) {
        boolean isDelete = service.delete(newFeedback);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }

}
