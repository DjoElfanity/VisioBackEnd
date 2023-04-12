package com.visioconference.visioservice.controller;

import com.visioconference.visioservice.entities.Meeting;
import com.visioconference.visioservice.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    public List<Meeting> getAllMessages(){
        return meetingService.getAllMeetings();
    };

    @GetMapping("/{id}")
    public Meeting getMessageById(@PathVariable int id)
    {
        return meetingService.getMeetingById(id);
    }

    @PostMapping("/add")
    public Meeting createMessage(@RequestBody Meeting meeting)
    {
        return meetingService.createMeeting(meeting);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id)
    {
        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public Meeting updateMessage(@PathVariable int id, @RequestBody Meeting meeting)
    {
        return meetingService.updateMeeting(id , meeting);
    }
}
