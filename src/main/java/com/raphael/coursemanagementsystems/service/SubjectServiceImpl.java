package com.raphael.coursemanagementsystems.service;

import com.raphael.coursemanagementsystems.data.model.Subject;
import com.raphael.coursemanagementsystems.data.model.User;
import com.raphael.coursemanagementsystems.data.repository.SubjectRepository;
import com.raphael.coursemanagementsystems.data.repository.UserRepository;
import com.raphael.coursemanagementsystems.dtos.request.AddSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateSubjectRequest;
import com.raphael.coursemanagementsystems.dtos.response.AddSubjectResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateSubjectResponse;
import com.raphael.coursemanagementsystems.exceptions.SubjectManagementException;
import com.raphael.coursemanagementsystems.exceptions.UserManagementException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    @Override
    public AddSubjectResponse addSubject(String userId, AddSubjectRequest addSubjectRequest) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("user does not exist");
        }
        User user = optionalUser.get();
        Optional<Subject> optionalSubject = subjectRepository.findByTitle(addSubjectRequest.getTitle());
        if (optionalSubject.isPresent()){
            throw new SubjectManagementException("subject with the title " + addSubjectRequest.getTitle() + " already exist");
        }
        Subject subject = new Subject(
                addSubjectRequest.getTitle(),
                addSubjectRequest.getDescription()
        );
        subjectRepository.save(subject);
        user.getSubjectList().add(subject);
        userRepository.save(user);
        AddSubjectResponse addSubjectResponse = new AddSubjectResponse();
        addSubjectResponse.setMessage("subject successfully added");
        return addSubjectResponse;
    }

    @Override
    public Subject getSubjectById(String subjectId) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject with the id " + subjectId + " does not exist");
        }
        return optionalSubject.get();
    }

    @Override
    public Subject getSubjectByTitle(String title) {
        Optional<Subject> optionalSubject = subjectRepository.findByTitle(title);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject with the title " + title + "does not exist");
        }
        return optionalSubject.get();
    }

    @Override
    public List<Subject> getAllSubjectByUser(String userId) {
        return subjectRepository.findAllSubjectByUser(userId);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }


    @Override
    public UpdateSubjectResponse updateSubject(String userId, String subjectId, UpdateSubjectRequest updateSubjectRequest) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user with the id " + userId + " does not exist");
        }
        User user = optionalUser.get();
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject does not exist");
        }
        Subject subject = optionalSubject.get();
        if (updateSubjectRequest.getTitle() != null){
            subject.setTitle(updateSubjectRequest.getTitle());
        }
        if (updateSubjectRequest.getDescription() != null){
            subject.setDescription(updateSubjectRequest.getDescription());
        }
        subjectRepository.save(subject);
        user.getSubjectList().removeIf(foundSubject -> foundSubject.getSubjectId().equals(user.getUserId())); // check this
        // also ask wale if we can use id in dto
        user.getSubjectList().add(subject);
        userRepository.save(user);
        UpdateSubjectResponse updateSubjectResponse = new UpdateSubjectResponse();
        updateSubjectResponse.setMessage("update request was successful");
        return updateSubjectResponse;
    }

    @Override
    public void deleteSubject(String userId, String subjectId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new UserManagementException("user with the id " + userId + " does not exist");
        }
        User user = optionalUser.get();
        Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
        if (optionalSubject.isEmpty()){
            throw new SubjectManagementException("subject with the id " + subjectId + " does not exist");
        }
        Subject subject = optionalSubject.get();
        subjectRepository.delete(subject);
        user.getSubjectList().remove(subject);
        userRepository.save(user);

    }

    @Override
    public void deleteAllSubjectByUser(String userId) {
       subjectRepository.deleteAllByUser(userId);
    }

    @Override
    public void deleteAllSubject() {
        subjectRepository.deleteAll();
    }
}
