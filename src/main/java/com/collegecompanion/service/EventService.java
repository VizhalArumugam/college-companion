package com.collegecompanion.service;

import com.collegecompanion.model.Event;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventService {
    public List<Event> getEvents() {
        return Arrays.asList(
                new Event(1, "Hackathon", "2025-09-10", "Auditorium"),
                new Event(2, "Cultural Fest", "2025-10-05", "Main Ground"),
                new Event(3, "Guest Lecture: AI Trends", "2025-09-20", "Seminar Hall")
        );
    }
}
