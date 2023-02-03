package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Course;
import com.raphael.coursemanagementsystems.dtos.request.AddCourseRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddCourseResponse;
import com.raphael.coursemanagementsystems.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("subjects/courses")
public class CourseControllerImpl implements CourseController{

    @Autowired
    private final CourseService courseService;

    @Override
    @PostMapping("/add")
    public AddCourseResponse addCourse(String subjectId, AddCourseRequest addCourseRequest) {
        return courseService.addCourse(subjectId, addCourseRequest);
    }

    @Override
    @GetMapping("/get/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }

    @Override
    @GetMapping("/get/{title}")
    public Course getCourseByTitle(@PathVariable String title) {
        return courseService.getCourseByTitle(title);
    }

    @Override
    @GetMapping("/subject/all-")
    public List<Course> getAllCoursesBySubject(String subjectId) {
        return courseService.getAllCoursesBySubject(subjectId);
    }

    @Override
    @GetMapping("/get-all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Override
    @PutMapping("/update/{subjectId}/{courseId}")
    public String updateCourse(
            @PathVariable String subjectId,
            @PathVariable String courseId,
            @RequestParam String title,
            @RequestParam String description) {
        courseService.updateCourse(subjectId, courseId, title, description);
        return "updated Successfully";
    }

    @Override
    @DeleteMapping("/delete/{subjectId}/{courseId}")
    public String deleteCourseById(@PathVariable String subjectId, @PathVariable String courseId) {
        courseService.deleteCourseById(subjectId, courseId);
        return "deleted successfully";
    }

    @Override
    public String deleteAllCourseBySubject(String subjectId) {
        courseService.deleteAllCoursesBySubject(subjectId);
        return "successfully deleted";
    }

    @Override
    @DeleteMapping("delete/all")
    public String deleteAllCourses() {
        courseService.deleteAllCourses();
        return "deleted successfully";
    }
}
