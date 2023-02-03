package com.raphael.coursemanagementsystems.service;

import com.raphael.coursemanagementsystems.data.model.Course;
import com.raphael.coursemanagementsystems.data.model.Lesson;
import com.raphael.coursemanagementsystems.data.repository.CourseRepository;
import com.raphael.coursemanagementsystems.data.repository.LessonRepository;
import com.raphael.coursemanagementsystems.data.repository.SubjectRepository;
import com.raphael.coursemanagementsystems.dtos.request.AddLessonRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddLessonResponse;
import com.raphael.coursemanagementsystems.exceptions.CourseManagementException;
import com.raphael.coursemanagementsystems.exceptions.LessonManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{
    @Autowired
    private final LessonRepository lessonRepository;
    @Autowired
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public AddLessonResponse addLesson(String courseId, AddLessonRequest addLessonRequest) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course not found");
        }
        Course course = optionalCourse.get();
        Lesson lesson = new Lesson(
                addLessonRequest.getTitle(),
                addLessonRequest.getDescription()
        );
        lessonRepository.save(lesson);
        course.getLessonList().add(lesson);
        courseRepository.save(course);
        AddLessonResponse addLessonResponse = new AddLessonResponse();
        addLessonResponse.setMessage("lesson was successfully");
        return addLessonResponse;
    }

    @Override
    public Lesson getLesson(String lessonId) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        if (optionalLesson.isEmpty()){
            throw new LessonManagementException("lesson not found");
        }
        return optionalLesson.get();
    }

    @Override
    public Lesson getLessonByTitle(String title) {
        Optional<Lesson> optionalLesson = lessonRepository.findByTitle(title);
        if (optionalLesson.isEmpty()){
            throw new LessonManagementException("lesson cannot be found");
        }
        return optionalLesson.get();
    }

    @Override
    public List<Lesson> getAllLessonByCourse(String courseId) {
                return lessonRepository.getAllLessonByCourse(courseId);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public void updateLesson(String courseId, String lessonId, String title, String description) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course not found");
        }
        Course course = optionalCourse.get();
        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        if (optionalLesson.isEmpty()){
            throw new LessonManagementException("lesson not found");
        }
        Lesson lesson = optionalLesson.get();
        if (title != null){
            lesson.setTitle(title);
        }
        if (description != null){
            lesson.setDescription(description);
        }
        lessonRepository.save(lesson);
        course.getLessonList().removeIf(foundLesson -> foundLesson.getLessonId().equals(lesson.getLessonId()));
        course.getLessonList().add(lesson);
        courseRepository.save(course);
    }


    @Override
    public void deleteLessonById(String courseId, String lessonId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course not found");
        }
        Course course = optionalCourse.get();
        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        if (optionalLesson.isEmpty()){
            throw new LessonManagementException("lesson cannot found");
        }
        Lesson lesson = optionalLesson.get();
        lessonRepository.delete(lesson);
        course.getLessonList().remove(lesson);
        courseRepository.save(course);

    }

    @Override
    public void deleteAllLessonByCourse(String courseId) {
        lessonRepository.deleteAllLessonByCourse(courseId);

    }
    @Override
    public void deleteAllLesson() {
        lessonRepository.deleteAll();
    }
}
