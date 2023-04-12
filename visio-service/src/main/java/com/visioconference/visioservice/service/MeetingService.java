package com.visioconference.visioservice.service;

import com.visioconference.visioservice.entities.Meeting;
import com.visioconference.visioservice.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> getAllMeetings() { return meetingRepository.findAll(); }
    public Meeting createMeeting(Meeting meeting)
    {
        return meetingRepository.save(meeting);
    }

    public Meeting getMeetingById(int id) {
        return meetingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public void deleteMeeting(int id)
    {
        Meeting notification = meetingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        meetingRepository.delete(notification);
    }

    public Meeting updateMeeting(int id, Meeting meeting)
    {
        Meeting existingMeeting = meetingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        existingMeeting.setDuration(meeting.getDuration());
        existingMeeting.setDescription(meeting.getDescription());
        existingMeeting.setHostId(meeting.getHostId());
        existingMeeting.setTitle(meeting.getTitle());
        existingMeeting.setEndDateTime(meeting.getEndDateTime());
        existingMeeting.setRecorded(meeting.isRecorded());
        existingMeeting.setStartDateTime(meeting.getStartDateTime()); //facultatif
        return meetingRepository.save(existingMeeting);
    }
}
