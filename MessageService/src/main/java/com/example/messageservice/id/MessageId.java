package com.example.messageservice.id;

import java.io.Serializable;
import java.util.Date;

public class MessageId implements Serializable {
    private int id , senderId , recipentId;
    private String content  ;

    private Date sendDateTime ;
    private boolean isPrivate;
}
