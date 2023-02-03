package com.raphael.coursemanagementsystems.data.repository;

import com.raphael.coursemanagementsystems.data.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface LessonRepository extends MongoRepository<Lesson, String> {

    Optional<Lesson> findByTitle(String title);

    List<Lesson> getAllLessonByCourse(String courseId);

    void deleteAllLessonByCourse(String courseId);
}
