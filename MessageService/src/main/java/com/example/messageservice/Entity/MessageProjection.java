package com.example.messageservice.Entity;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullMessage" , types = Message.class)
public class MessageProjection {


}
