package com.example.messageservice.Repository;


import com.example.messageservice.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository  extends JpaRepository<Message, Integer> {

Message findBySenderId(String senderId);
Message findByRecipentId(String recipentId);
}
