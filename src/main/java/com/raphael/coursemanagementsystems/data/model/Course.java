package com.raphael.coursemanagementsystems.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseId;
    private String title;
    private String description;
    private Subject subject;
    @CreationTimestamp
    private Timestamp createdAt;
    @CreationTimestamp
    private Timestamp updatedAt;
    private List<Lesson> lessonList;

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
        lessonList = new ArrayList<>();
    }
}
