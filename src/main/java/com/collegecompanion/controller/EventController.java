package com.collegecompanion.controller;

import com.collegecompanion.model.Event;
import com.collegecompanion.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        return eventService.updateEvent(id,event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return "Event deleted with id "+id;
    }
}
