package com.raphael.coursemanagementsystems.service;

import com.raphael.coursemanagementsystems.data.model.Lesson;
import com.raphael.coursemanagementsystems.dtos.request.AddLessonRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddLessonResponse;

import java.util.List;

public interface LessonService {
    AddLessonResponse addLesson(String courseId, AddLessonRequest addLessonRequest);

    Lesson getLesson(String lessonId);
    Lesson getLessonByTitle(String title);
    List<Lesson> getAllLessonByCourse(String courseId);
    List<Lesson> getAllLessons();


    void updateLesson(String courseId, String lessonId, String title, String description);


    void deleteLessonById(String courseId, String lessonId);
    void deleteAllLessonByCourse(String courseId);
    void deleteAllLesson();
}
