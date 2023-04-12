package com.visioconference.visioservice.service;

import com.visioconference.visioservice.entities.Meeting;
import com.visioconference.visioservice.entities.Webinaire;
import com.visioconference.visioservice.repository.MeetingRepository;
import com.visioconference.visioservice.repository.WebinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebinarService {
    @Autowired
    private WebinarRepository webinarRepository;

    public List<Webinaire> getAllWebinars() { return webinarRepository.findAll(); }
    public Webinaire createWebinar(Webinaire webinaire)
    {
        return webinarRepository.save(webinaire);
    }

    public Webinaire getWebinarById(int id) {
        return webinarRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public void deleteWebinar(int id)
    {
        Webinaire webinaire = webinarRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        webinarRepository.delete(webinaire);
    }

    public Webinaire updateWebinar(int id, Webinaire webinaire)
    {
        Webinaire existingWebinaire = webinarRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        existingWebinaire.setDuration(webinaire.getDuration());
        existingWebinaire.setDescription(webinaire.getDescription());
        existingWebinaire.setHostId(webinaire.getHostId());
        existingWebinaire.setTitle(webinaire.getTitle());
        existingWebinaire.setEndDateTime(webinaire.getEndDateTime());
        existingWebinaire.setRecorded(webinaire.isRecorded());

        return webinarRepository.save(existingWebinaire);
    }
}
