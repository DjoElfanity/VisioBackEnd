package com.example.userservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Data
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id  ;
    private String nom , prenom , username , email  , password ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;


}
