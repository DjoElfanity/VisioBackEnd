package com.example.messageservice.Service;


import com.example.messageservice.Entity.Message;
import com.example.messageservice.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages()
    {
        return messageRepository.findAll();
    }

    public Message getMessageById(int id)
    {
        return messageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException()
        );

    }

    public Message createMessage(Message message)
    {
        return messageRepository.save(message);
    }

    public Message updateMessage(int id, Message message)
    {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
       // existingMessage.setPrivate(message.());
        existingMessage.setContent(message.getContent());
        existingMessage.setSenderId(message.getSenderId());
        existingMessage.setRecipentId(message.getRecipentId());
        existingMessage.setSendDateTime(message.getSendDateTime());

        return messageRepository.save(existingMessage);
    }

    public void deleteMessage(int id)
    {
        Message message = messageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException()
        );
        messageRepository.delete(message);
    }
}
