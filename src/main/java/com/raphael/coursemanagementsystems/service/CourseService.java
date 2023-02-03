package com.raphael.coursemanagementsystems.service;


import com.raphael.coursemanagementsystems.data.model.Course;
import com.raphael.coursemanagementsystems.dtos.request.AddCourseRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddCourseResponse;

import java.util.List;


public interface CourseService {

    AddCourseResponse addCourse(String subjectId, AddCourseRequest addCourseRequest);

    Course getCourseById(String courseId);

    Course getCourseByTitle(String title);


    List<Course> getAllCourses();

    void updateCourse(String subjectId, String courseId, String title, String description);

    void deleteCourseById(String courseId);

    void deleteAllCoursesBySubject(String subjectId);

    List<Course> getAllCoursesBySubject(String subjectId);

}