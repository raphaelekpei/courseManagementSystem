package com.raphael.coursemanagementsystems.service;

import com.raphael.coursemanagementsystems.data.model.Subject;
import com.raphael.coursemanagementsystems.dtos.request.AddSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddSubjectResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateSubjectResponse;

import java.util.List;

public interface SubjectService {
    AddSubjectResponse addSubject(String userId, AddSubjectRequest addSubjectRequest);

    Subject getSubjectById(String subjectId);

    Subject getSubjectByTitle(String title);
    List<Subject> getAllSubjectByUser(String userId);

    List<Subject> getAllSubject();



    UpdateSubjectResponse updateSubject(String userId, String subjectId, UpdateSubjectRequest updateSubjectRequest);

    void deleteSubject(String userId, String subjectId);

    void deleteAllSubjectByUser(String userId);

    void deleteAllSubject();

}
