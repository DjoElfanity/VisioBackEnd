package com.visioconference.visioservice.controller;

import com.visioconference.visioservice.entities.Conference;
import com.visioconference.visioservice.entities.Meeting;
import com.visioconference.visioservice.service.ConferenceService;
import com.visioconference.visioservice.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/conference")
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/")
    public List<Conference> getAllMessages(){
        return conferenceService.getAllConferences();
    };

    @GetMapping("/{id}")
    public Conference getMessageById(@PathVariable int id)
    {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping("/add")
    public Conference createMessage(@RequestBody Conference conference)
    {
        return conferenceService.createConference(conference);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id)
    {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public Conference updateMessage(@PathVariable int id, @RequestBody Conference conference)
    {
        return conferenceService.updateConference(id , conference);
    }
}
