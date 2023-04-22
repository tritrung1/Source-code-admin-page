package com.training.mapper;

import com.training.dto.NotificationDTO;
import com.training.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper extends AbstractMapper<Notification, NotificationDTO>{
    public NotificationMapper() {
        super(Notification.class, NotificationDTO.class);
    }
}
