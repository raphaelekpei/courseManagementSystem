package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Subject;
import com.raphael.coursemanagementsystems.dtos.request.AddSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddSubjectResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateSubjectResponse;
import com.raphael.coursemanagementsystems.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
@Validated
public class SubjectControllerImpl implements SubjectController{

    @Autowired
    private final SubjectService subjectService;

    @Override
    @PostMapping("/new")
    public AddSubjectResponse addSubject(String userId, AddSubjectRequest addSubjectRequest) {
        return subjectService.addSubject(userId, addSubjectRequest);
    }

    @Override
    @GetMapping("/view/{subjectId}")
    public Subject getSubjectById(@PathVariable @Valid String subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @Override
    @GetMapping("/view{title}")
    public Subject getSubjectByTitle(@PathVariable @Valid String title) {
        return subjectService.getSubjectByTitle(title);
    }

    @Override
    @GetMapping("/get-all/{userId}")
    public List<Subject> getAllSubjectByUser(@PathVariable @Valid String userId) {
        return subjectService.getAllSubjectByUser(userId);
    }

    @Override
    @GetMapping("get/all")
    public List<Subject> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @Override
    @PutMapping("/update/{subjectId}/{subjectId}")
    public UpdateSubjectResponse updateSubject(
            @PathVariable String userId,
            @PathVariable String subjectId,
            @RequestBody @Valid UpdateSubjectRequest updateSubjectRequest) {
        return subjectService.updateSubject(userId, subjectId, updateSubjectRequest);
    }

    @Override
    @DeleteMapping("/delete/{userId}/{subjectId}")
    public String deleteSubject(@PathVariable String userId, @PathVariable String subjectId) {
        subjectService.deleteSubject(userId, subjectId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete-all/{userId}")
    public String deleteAllSubjectByUser(@PathVariable String userId) {
        subjectService.deleteAllSubjectByUser(userId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete/all")
    public String deleteAllSubject() {
        subjectService.deleteAllSubject();
        return "deleted successfully";
    }
}
