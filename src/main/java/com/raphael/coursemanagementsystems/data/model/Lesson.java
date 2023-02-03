package com.raphael.coursemanagementsystems.data.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.security.Timestamp;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
   // @Getter(AccessLevel.NONE)
   // @Setter(AccessLevel.NONE)
    @Id
    private String lessonId;
    private String title;
    private String description;
    @CreationTimestamp
    private Timestamp createdAt;
    @CreationTimestamp
    private Timestamp updatedAt;
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Lesson(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
