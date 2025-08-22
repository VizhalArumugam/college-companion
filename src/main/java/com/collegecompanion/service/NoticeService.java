package com.collegecompanion.service;

import com.collegecompanion.model.Notice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoticeService {
    public List<Notice> getNotices() {
        return Arrays.asList(
                new Notice(1, "Holiday on 29th Aug", "2025-08-29"),
                new Notice(2, "Hackathon Registration Open", "2025-09-01"),
                new Notice(3, "Midterm Exams Start", "2025-09-15")
        );
    }
}
