package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Subject;
import com.raphael.coursemanagementsystems.dtos.request.AddSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddSubjectResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateSubjectResponse;

import java.util.List;

public interface SubjectController {

    public AddSubjectResponse addSubject(String userId, AddSubjectRequest addSubjectRequest);

    public Subject getSubjectById(String subjectId);
    public Subject getSubjectByTitle(String title);
    public List<Subject> getAllSubjectByUser(String userId);
    public List<Subject> getAllSubject();

    public UpdateSubjectResponse updateSubject(String userId, String subjectId, UpdateSubjectRequest updateSubjectRequest);

    public String deleteSubject(String userId, String subjectId);
    public String deleteAllSubjectByUser(String userId);
    public String deleteAllSubject();


}
