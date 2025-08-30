package com.collegecompanion.repository;

import com.collegecompanion.model.AppUser;
import com.collegecompanion.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    List<FileEntity> id(Long id);
    List<FileEntity> findBySubject(String subject);
    List<FileEntity> findByUploader(AppUser uploader);

}
