package com.visioconference.visioservice.service;

import com.visioconference.visioservice.entities.Conference;
import com.visioconference.visioservice.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferences() { return conferenceRepository.findAll(); }
    public Conference createConference(Conference conference)
    {
        return conferenceRepository.save(conference);
    }

    public Conference getConferenceById(int id) {
        return conferenceRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteConference(int id)
    {
        Conference conference = conferenceRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        conferenceRepository.delete(conference);
    }

    public Conference updateConference(int id, Conference conference)
    {
        Conference existingConference = conferenceRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        existingConference.setDescription(conference.getDescription());
        existingConference.setHostId(conference.getHostId());
        existingConference.setTitle(conference.getTitle());
        existingConference.setEndDateTime(conference.getEndDateTime());

        return conferenceRepository.save(existingConference);
    }
}
