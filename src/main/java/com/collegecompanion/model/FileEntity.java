package com.collegecompanion.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    private String description;
    private String fileName;
    private String filePath;
    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private AppUser uploader;
}
