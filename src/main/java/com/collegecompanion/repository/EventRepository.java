package com.collegecompanion.repository;

import com.collegecompanion.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {}
