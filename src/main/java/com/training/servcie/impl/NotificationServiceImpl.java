package com.training.servcie.impl;

import com.training.dto.NotificationDTO;
import com.training.entity.Notification;
import com.training.mapper.NotificationMapper;
import com.training.repository.NotificationRepository;
import com.training.servcie.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository repository;

    @Autowired
    NotificationMapper mapper;
    @Override
    public List<NotificationDTO> findAll() {
        List<Notification> notifications = repository.findAll();
        return notifications == null || notifications.size() == 0 ? new ArrayList<>()
                : notifications.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO findById(Long id) {
        Optional<Notification> notification = repository.findById(id);
        return notification != null && notification.isPresent() ? mapper.convertEntityToDTO(notification.get())
                : new NotificationDTO();
    }

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        if (notificationDTO == null) return new NotificationDTO();
        Notification notification = repository.save(mapper.convertDTOToEntity(notificationDTO));
        return notification == null ? new NotificationDTO() : mapper.convertEntityToDTO(notification);
    }

    @Override
    public int update(NotificationDTO notificationDTO) {
        if (notificationDTO == null || notificationDTO.getId() == null) return -1;
        Optional<Notification> notification = repository.findById(notificationDTO.getId());
        if (notification != null && notification.isPresent()) {
            //update
            Notification notificationUpdate = repository.save(mapper.convertDTOToEntity(notificationDTO));
            return notificationUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(NotificationDTO notificationDTO) {
        try {
            if (notificationDTO == null || notificationDTO.getId() == null) return false;
            Optional<Notification> notification = repository.findById(notificationDTO.getId());
            if (notification != null && notification.isPresent()) {
                //delete
                repository.delete(notification.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
