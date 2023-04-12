package com.visioconference.visioservice.repository;

import com.visioconference.visioservice.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
    Meeting findById(String id);
    Meeting findByTitle(String title);
    Meeting findByHostId(String id);
    Meeting findByStartDateTime(Date date);
    Meeting findByEndDateTime(Date date);
}
