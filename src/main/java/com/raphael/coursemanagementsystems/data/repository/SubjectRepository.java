package com.raphael.coursemanagementsystems.data.repository;

import com.raphael.coursemanagementsystems.data.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface SubjectRepository extends MongoRepository<Subject, String> {
    Optional<Subject> findByTitle(String title);

    List<Subject> findAllSubjectByUser(String userId);

    void deleteAllByUser(String userId);
}
