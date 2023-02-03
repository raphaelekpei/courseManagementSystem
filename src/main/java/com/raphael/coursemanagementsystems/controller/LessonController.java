package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.Lesson;
import com.raphael.coursemanagementsystems.dtos.request.AddLessonRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddLessonResponse;

import java.util.List;

public interface LessonController {
    public AddLessonResponse addLesson(String courseId, AddLessonRequest addLessonRequest);

    public Lesson getLessonById(String lessonId);
    public Lesson getLessonByTitle(String title);
    public List<Lesson> getAllLessonByCourse(String courseId);
    public List<Lesson> getAllLessons();

    public String updateLesson(String courseId, String lessonId, String title, String description);

    public String deleteLessonById(String courseId, String lessonId);
    public String deleteAllLessonByCourse(String courseId);
    public String deleteAllLessons();
}
