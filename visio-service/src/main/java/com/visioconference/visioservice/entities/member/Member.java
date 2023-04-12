package com.visioconference.visioservice.entities.member;

import com.visioconference.visioservice.entities.Visio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private String id;
    private String username;

    @ManyToOne
    private Visio myVisio;
}
