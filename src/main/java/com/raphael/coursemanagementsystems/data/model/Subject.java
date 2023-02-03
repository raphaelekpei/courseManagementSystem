package com.raphael.coursemanagementsystems.data.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Subject {

    @Id
    private String subjectId;
    private String title;
    private String description;

    @CreationTimestamp
    private Timestamp createdAt;

    @CreationTimestamp
    private Timestamp updatedAt;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private List<Course> courseList = new ArrayList<>();

    public Subject(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
