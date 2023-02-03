package com.raphael.coursemanagementsystems.service;

import com.raphael.coursemanagementsystems.data.model.Course;
import com.raphael.coursemanagementsystems.data.model.Subject;
import com.raphael.coursemanagementsystems.data.repository.CourseRepository;
import com.raphael.coursemanagementsystems.data.repository.SubjectRepository;
import com.raphael.coursemanagementsystems.dtos.request.AddCourseRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddCourseResponse;
import com.raphael.coursemanagementsystems.exceptions.CourseManagementException;
import com.raphael.coursemanagementsystems.exceptions.SubjectManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final SubjectRepository subjectRepository;
    @Override
    public AddCourseResponse addCourse(String subjectId, AddCourseRequest addCourseRequest) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject does not exist");
        }
        Subject subject = optionalSubject.get();
        Optional<Course> optionalCourse = courseRepository.findByTitle(addCourseRequest.getTitle());
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course with the title "
                    + addCourseRequest.getTitle() + " already exist. Please rename it");
        }
        Course course = new Course(
                addCourseRequest.getTitle(),
                addCourseRequest.getDescription()
        );
        courseRepository.save(course);
        subject.getCourseList().add(course);
        subjectRepository.save(subject);
        AddCourseResponse addCourseResponse = new AddCourseResponse();
        addCourseResponse.setMessage("course has been successfully saved");
        return addCourseResponse;
    }

    @Override
    public Course getCourseById(String courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course does not exist");
        }
        return optionalCourse.get();
    }

    @Override
    public Course getCourseByTitle(String title) {
        Optional<Course> optionalCourse = courseRepository.findByTitle(title);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course does not exist");
        }
        return optionalCourse.get();

    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCoursesBySubject(String subjectId) {
        return courseRepository.getAllCoursesBySubject(subjectId);
    }

    @Override
    public void updateCourse(String subjectId, String courseId, String title, String description) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject does not exist");
        }
        Subject subject = optionalSubject.get();
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course does not exist");
        }
        Course course = optionalCourse.get();
        if (title != null){
            course.setTitle(title);
        }
        if (description != null){
            course.setDescription(description);
        }
        courseRepository.save(course);
        subject.getCourseList().removeIf(foundCourse -> foundCourse.getCourseId().equals(course.getCourseId()));
        subject.getCourseList().add(course);
        subjectRepository.save(subject);
    }


    @Override
    public void deleteCourseById(String subjectId, String courseId) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject cannot found");
        }
        Subject subject = optionalSubject.get();
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isEmpty()){
            throw new CourseManagementException("course does not exist");
        }
        Course course = optionalCourse.get();
        courseRepository.delete(course);
        subject.getCourseList().remove(course);
        subjectRepository.save(subject);
    }

    @Override
    public void deleteAllCoursesBySubject(String subjectId) {
        courseRepository.deleteAllCoursesBySubject(subjectId);
    }
    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
