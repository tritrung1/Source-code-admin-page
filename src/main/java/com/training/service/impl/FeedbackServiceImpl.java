package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.FeedbackDTO;
import com.training.entity.Feedback;
import com.training.mapper.FeedbackMapper;
import com.training.repository.FeedbackRepository;
import com.training.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository repository;

    @Autowired
    FeedbackMapper mapper;

    @Override
    public List<FeedbackDTO> findAll() {
        List<Feedback> feedbacks = repository.findAll();
        return feedbacks == null || feedbacks.size() == 0 ? new ArrayList<>()
                : feedbacks.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDTO findById(Long id) {
        Optional<Feedback> feedback = repository.findById(id);
        return feedback != null && feedback.isPresent() ? mapper.convertEntityToDTO(feedback.get())
                : new FeedbackDTO();
    }

    @Override
    public FeedbackDTO save(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null) return new FeedbackDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        feedbackDTO.setFeedbackUuid(uuid.toString());

        Feedback feedback = repository.save(mapper.convertDTOToEntity(feedbackDTO));
        return feedback == null ? new FeedbackDTO() : mapper.convertEntityToDTO(feedback);
    }

    @Override
    public int update(FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null || feedbackDTO.getId() == null) return -1;
        Optional<Feedback> feedback = repository.findById(feedbackDTO.getId());
        if (feedback != null && feedback.isPresent()) {
            //update
            Feedback feedbackUpdate = repository.save(mapper.convertDTOToEntity(feedbackDTO));
            return feedbackUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(FeedbackDTO feedbackDTO) {
        try {
            if (feedbackDTO == null || feedbackDTO.getId() == null) return false;
            Optional<Feedback> feedback = repository.findById(feedbackDTO.getId());
            if (feedback != null && feedback.isPresent()) {
                //delete
                repository.delete(feedback.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}