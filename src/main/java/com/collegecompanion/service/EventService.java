package com.collegecompanion.service;

import com.collegecompanion.model.Event;
import com.collegecompanion.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    public final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Integer id,Event update) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setName(update.getName());
                    event.setDate(update.getDate());
                    event.setLocation(update.getLocation());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id "+id));
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
