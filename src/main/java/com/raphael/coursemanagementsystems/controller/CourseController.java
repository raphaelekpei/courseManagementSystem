package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Course;
import com.raphael.coursemanagementsystems.dtos.request.AddCourseRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddCourseResponse;

import java.util.List;

public interface CourseController {
    public AddCourseResponse addCourse(String subjectId, AddCourseRequest addCourseRequest);
    public Course getCourseById (String courseId);
    public Course getCourseByTitle(String title);
    public List<Course> getAllCoursesBySubject(String subjectId);
    public List<Course> getAllCourses();

    public String updateCourse(String subjectId, String courseId, String title, String description);
    public String deleteCourseById(String subjectId, String courseId);
    public String deleteAllCourseBySubject(String subjectId);
    public String deleteAllCourses();



}
