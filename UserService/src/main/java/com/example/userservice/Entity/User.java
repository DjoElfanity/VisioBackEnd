package com.example.userservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Builder
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id ;
    private String nom , prenom , username , email  , password ;

    private Date dateNaissance;


}
