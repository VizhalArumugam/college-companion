package com.collegecompanion.service;

import com.collegecompanion.model.Notice;
import com.collegecompanion.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoticeService {
    public final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> getNotices() {
        return noticeRepository.findAll();
    }
    public Notice addNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Notice updateNotice(Integer id, Notice update) {
        return noticeRepository.findById(id)
                .map(notice -> {
                    notice.setContent(update.getContent());
                    notice.setDate(update.getDate());
                    return noticeRepository.save(notice);
                })
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + id));
    }

    public void deleteNotice(Integer id){
        noticeRepository.deleteById(id);
    }
}
