package com.training.service;

import com.training.dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService extends BaseService<FeedbackDTO>{
    List<FeedbackDTO> findByStatus();
}
