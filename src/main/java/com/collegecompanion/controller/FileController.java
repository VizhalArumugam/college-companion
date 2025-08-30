package com.collegecompanion.controller;

import com.collegecompanion.model.FileEntity;
import com.collegecompanion.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @Operation(summary = "Upload a file")
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public FileEntity upload(
            @Parameter(description = "File to upload")
            @RequestParam("file") MultipartFile file,
            @RequestParam("subject") String subject,
            @RequestParam("description") String description,
            @Parameter(description = "Uploader name")
            @RequestParam("uploader") String username
    ) throws IOException {
        return fileService.uploadFile(file,subject,description,username);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) throws IOException {
        FileEntity fileEntity = fileService.getFile(id);

        Path path = Paths.get(fileEntity.getFilePath());
        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("File not found or not readable: " + fileEntity.getFileName());
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @GetMapping
    public List<FileEntity> listFiles(
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) String uploader) {
        return fileService.listFiles(subject, uploader);
    }
}
