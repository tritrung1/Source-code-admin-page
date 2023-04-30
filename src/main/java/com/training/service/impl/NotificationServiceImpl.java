package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.NotificationDTO;
import com.training.entity.Notification;
import com.training.mapper.NotificationMapper;
import com.training.repository.NotificationRepository;
import com.training.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationMapper notificationMapper;
    @Override
    public List<NotificationDTO> findAll() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications == null || notifications.size() == 0 ? new ArrayList<>()
                : notifications.stream().map(item -> notificationMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO findById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        return notification != null && notification.isPresent() ? notificationMapper.convertEntityToDTO(notification.get())
                : new NotificationDTO();
    }

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        if (notificationDTO == null) return new NotificationDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        notificationDTO.setNotificationUuid(uuid.toString());

        Notification notification = notificationRepository.save(notificationMapper.convertDTOToEntity(notificationDTO));
        return notification == null ? new NotificationDTO() : notificationMapper.convertEntityToDTO(notification);
    }

    @Override
    public int update(NotificationDTO notificationDTO) {
        if (notificationDTO == null || notificationDTO.getId() == null) return -1;
        Optional<Notification> notification = notificationRepository.findById(notificationDTO.getId());
        if (notification != null && notification.isPresent()) {
            //update
            Notification notificationUpdate = notificationRepository.save(notificationMapper.convertDTOToEntity(notificationDTO));
            return notificationUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(NotificationDTO notificationDTO) {
        try {
            if (notificationDTO == null || notificationDTO.getId() == null) return false;
            Optional<Notification> notification = notificationRepository.findById(notificationDTO.getId());
            if (notification != null && notification.isPresent()) {
                //delete
                notificationRepository.delete(notification.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
