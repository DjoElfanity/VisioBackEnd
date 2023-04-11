package com.example.messageservice.Entity;

import com.example.messageservice.id.MessageId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Data
@Table(name = "MESSAGE")
@IdClass(MessageId.class)
public class Message {

    @Id @GeneratedValue()
    private int id , senderId , recipentId;
    private String content  ;

    private Date sendDateTime ;
    private boolean isPrivate;

}
