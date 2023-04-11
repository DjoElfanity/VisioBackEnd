package com.example.messageservice.Model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class User {


    private int id  ;
    private String nom , prenom , username , email  , password ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
}
