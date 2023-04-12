package com.visioconference.notificationservice.Controller;

import com.visioconference.notificationservice.Entities.NotificationData;
import com.visioconference.notificationservice.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/")
    public List<NotificationData> getAllMessages(){
        return notificationService.getAllNotifications();
    };

    @GetMapping("/{id}")
    public NotificationData getMessageById(@PathVariable int id)
    {
        return notificationService.getNotificationById(id);
    }

    @PostMapping("/add")
    public NotificationData createMessage(@RequestBody NotificationData notificationData)
    {
        return notificationService.createNotification(notificationData);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id)
    {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/notifications")
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationData notificationDto) {
        notificationService.sendNotification(notificationDto);
        return ResponseEntity.ok().build();
    }


}