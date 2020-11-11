package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("events-rest")
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(path="/{id}", produces = "application/json")
    public Event getEvent(@PathVariable int id) {
        return eventRepository.findById(id).get();
    }

    @GetMapping(path="/namesearch", produces = "application/json")
    public Event getEventByName(@RequestParam String name) {
        return eventRepository.findByName(name).get();
    }
}
