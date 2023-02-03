package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Lesson;
import com.raphael.coursemanagementsystems.dtos.request.AddLessonRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddLessonResponse;
import com.raphael.coursemanagementsystems.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("subjects/courses/lessons")
public class LessonControllerImpl implements LessonController{
    @Autowired
    private final LessonService lessonService;

    @Override
    @PostMapping("/add")
    public AddLessonResponse addLesson(String courseId, AddLessonRequest addLessonRequest) {
        return lessonService.addLesson(courseId, addLessonRequest);
    }

    @Override
    @GetMapping("/lesson/{lessonId}")
    public Lesson getLessonById(@PathVariable String lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @Override
    public Lesson getLessonByTitle(String title) {
        return lessonService.getLessonByTitle(title);
    }

    @Override
    @GetMapping("/all/{courseId}")
    public List<Lesson> getAllLessonByCourse(@PathVariable String courseId) {
        return lessonService.getAllLessonByCourse(courseId);
    }

    @Override
    @GetMapping("/get/all")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @Override
    @PutMapping("/update/{courseId}/{lessonId}")
    public String updateLesson(
            @PathVariable String courseId,
            @PathVariable String lessonId,
            @RequestParam String title,
            @RequestParam String description) {
        lessonService.updateLesson(courseId, lessonId, title, description);
        return "updated successfully";
    }

    @Override
    @DeleteMapping("/delete/{courseId}/{lessonId}")
    public String deleteLessonById(@PathVariable String courseId, @PathVariable String lessonId) {
        lessonService.deleteLessonById(courseId, lessonId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete/all/{courseId}")
    public String deleteAllLessonByCourse(@PathVariable String courseId) {
        lessonService.deleteAllLessonByCourse(courseId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("/delete/all")
    public String deleteAllLessons() {
        lessonService.deleteAllLesson();
        return "deleted successfully";
    }
}
