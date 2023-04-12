package com.visioconference.visioservice.repository;

import com.visioconference.visioservice.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
    Conference findById(String id);
    Conference findByTitle(String title);
    Conference findByHostId(String id);
    Conference findByStartDateTime(Date date);
    Conference findByEndDateTime(Date date);
}
