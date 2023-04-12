package com.visioconference.visioservice.controller;

import com.visioconference.visioservice.entities.Conference;
import com.visioconference.visioservice.entities.Webinaire;
import com.visioconference.visioservice.service.ConferenceService;
import com.visioconference.visioservice.service.WebinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/webinar")
public class WebinarController {
    @Autowired
    private WebinarService webinarService;

    @GetMapping("/")
    public List<Webinaire> getAllWebinars(){
        return webinarService.getAllWebinars();
    };

    @GetMapping("/{id}")
    public Webinaire getWebinarById(@PathVariable int id)
    {
        return webinarService.getWebinarById(id);
    }

    @PostMapping("/add")
    public Webinaire createWebinar(@RequestBody Webinaire webinaire)
    {
        return webinarService.createWebinar(webinaire);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteWebinar(@PathVariable int id)
    {
        webinarService.deleteWebinar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public Webinaire updateWebinar(@PathVariable int id, @RequestBody Webinaire webinaire)
    {
        return webinarService.updateWebinar(id , webinaire);
    }
}
