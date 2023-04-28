package com.training.mapper;

import com.training.dto.FeedbackDTO;
import com.training.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackMapper extends AbstractMapper<Feedback, FeedbackDTO> {
    public FeedbackMapper() {
        super(Feedback.class, FeedbackDTO.class);
    }
}
