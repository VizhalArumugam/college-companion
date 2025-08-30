package com.collegecompanion.service;

import com.collegecompanion.model.AppUser;
import com.collegecompanion.model.FileEntity;
import com.collegecompanion.repository.AppUserRepository;
import com.collegecompanion.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final FileRepository fileRepository;
    private final AppUserRepository appUserRepository;

    public FileService(FileRepository fileRepository,AppUserRepository appUserRepository) {
        this.fileRepository = fileRepository;
        this.appUserRepository = appUserRepository;
    }

    public FileEntity uploadFile(MultipartFile file,String subject,String description, String username) throws IOException {
        AppUser uploader = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);

        Files.createDirectories(filePath.getParent());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        FileEntity entity = new FileEntity();
        entity.setSubject(subject);
        entity.setDescription(description);
        entity.setFileName(file.getOriginalFilename());
        entity.setFilePath(filePath.toString());
        entity.setUploadDate(LocalDateTime.now());
        entity.setUploader(uploader);

        return fileRepository.save(entity);
    }

    public FileEntity getFile(Integer id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with ID: " + id));
    }

    public List<FileEntity> listFiles(String subject, String uploaderName) {
        if (subject != null) {
            return fileRepository.findBySubject(subject);
        }
        if (uploaderName != null) {
            AppUser uploader = appUserRepository.findByUsername(uploaderName)
                    .orElseThrow(() -> new RuntimeException("Uploader not found: " + uploaderName));
            return fileRepository.findByUploader(uploader);
        }
        return fileRepository.findAll();
    }


    public Resource downloadFile(Integer id) throws IOException {
        FileEntity fileEntity = fileRepository.findById(id)
                .orElseThrow(() -> new IOException("File not found with id: " + id));
        String fileName = fileEntity.getFileName();
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new IOException("File not found or not readable: " + fileName);
        }
    }
}
