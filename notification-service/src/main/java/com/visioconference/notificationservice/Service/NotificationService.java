package com.visioconference.notificationservice.Service;

import com.visioconference.notificationservice.Entities.NotificationData;
import com.visioconference.notificationservice.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    private JavaMailSender javaMailSender;

    public List<NotificationData> getAllNotifications() { return notificationRepository.findAll(); }
    public NotificationData createNotification(NotificationData notification)
    {
        return notificationRepository.save(notification);
    }

    public NotificationData getNotificationById(int id) {
        return notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public void deleteNotification(int id)
    {
        NotificationData notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        notificationRepository.delete(notification);
    }

    public void sendNotification(NotificationData notificationDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notificationDto.getRecipient());
        message.setSubject(notificationDto.getSubject());
        message.setText(notificationDto.getMessage());

        createNotification(notificationDto);
        javaMailSender.send(message);
        System.out.println("Notified");
    }
}
