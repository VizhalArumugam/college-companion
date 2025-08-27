package com.collegecompanion.controller;

import com.collegecompanion.model.Notice;
import com.collegecompanion.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // Only FACULTY can create
    @PostMapping
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        return ResponseEntity.ok(noticeService.addNotice(notice));
    }

    // Both FACULTY and STUDENT can view
    @GetMapping
    @PreAuthorize("hasAnyAuthority('FACULTY', 'STUDENT')")
    public ResponseEntity<List<Notice>> getAllNotices() {
        return ResponseEntity.ok(noticeService.getNotices());
    }

    // Only FACULTY can update
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<Notice> updateNotice(@PathVariable Integer id,
                                               @RequestBody Notice updatedNotice) {
        return ResponseEntity.ok(noticeService.updateNotice(id, updatedNotice));
    }

    // Only FACULTY can delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('FACULTY')")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
