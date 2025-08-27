package com.collegecompanion.repository;

import com.collegecompanion.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {}
