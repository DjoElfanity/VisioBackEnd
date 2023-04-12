package com.visioconference.notificationservice.Repository;

import com.visioconference.notificationservice.Entities.NotificationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationData, Integer> {
    NotificationData findById(String id);
    NotificationData findByRecipient(String recipientId);
    NotificationData findByMessage(String message);
}
