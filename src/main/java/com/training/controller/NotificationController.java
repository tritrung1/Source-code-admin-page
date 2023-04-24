package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.NotificationDTO;
import com.training.repository.NotificationRepository;
import com.training.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    NotificationService service;

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        return "Ping!!!!!!!!";
    }

    @PostMapping(value = ApiPath.NOTIFICATION_CREATE)
    public NotificationDTO newNotification(@RequestBody NotificationDTO newNotification) {
        return service.save(newNotification);
    }

    @GetMapping(value = ApiPath.NOTIFICATION_GET_ALL)
    public List<NotificationDTO> getAllNotifications() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.NOTIFICATION_BY_ID)
    public NotificationDTO getNotificationById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.NOTIFICATION_UPDATE)
    public Integer updateNotification(@RequestBody NotificationDTO newNotification) {
        return service.update(newNotification);
    }

    @DeleteMapping(value = ApiPath.NOTIFICATION_DELETE)
    public String deleteNotification(@RequestBody NotificationDTO newNotification) {
        boolean isDelete = service.delete(newNotification);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}
