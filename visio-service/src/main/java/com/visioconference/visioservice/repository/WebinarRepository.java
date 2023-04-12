package com.visioconference.visioservice.repository;

import com.visioconference.visioservice.entities.Webinaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WebinarRepository extends JpaRepository<Webinaire, Integer> {
    Webinaire findById(String id);
    Webinaire findByTitle(String title);
    Webinaire findByHostId(String id);
    Webinaire findByStartDateTime(Date date);
    Webinaire findByEndDateTime(Date date);
}
