package com.example.messageservice.Controller;


import com.example.messageservice.Entity.Message;
import com.example.messageservice.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public List<Message> getAllMessages()
    {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable int id)
    {
        return messageService.getMessageById(id);
    }

    @PostMapping("/add")
    public Message createMessage(@RequestBody Message message)
    {
        return messageService.createMessage(message);
    }

    @PostMapping("/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message)
    {
        return messageService.updateMessage(id , message);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id)
    {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

}
