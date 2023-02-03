package com.raphael.coursemanagementsystems.data.repository;

import com.raphael.coursemanagementsystems.data.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByTitle(String title);

    List<Course> getAllCoursesBySubject(String subjectId);

    void deleteAllCoursesBySubject(String subjectId);
}
