package com.raphael.coursemanagementsystems.service;


import com.raphael.coursemanagementsystems.data.model.User;
import com.raphael.coursemanagementsystems.dtos.request.LoginRequest;
import com.raphael.coursemanagementsystems.dtos.request.SignUpRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateUserRequest;
import com.raphael.coursemanagementsystems.dtos.response.LoginResponse;
import com.raphael.coursemanagementsystems.dtos.response.SignUpResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateUserResponse;

import java.util.List;

public interface UserService {
    SignUpResponse addUser(SignUpRequest signUpRequest);
    LoginResponse loginUser(LoginRequest loginRequest);

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserById(String userId);

    List<User> getAllUser();

    UpdateUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest);

    void deleteUserById(String userId);

    void deleteAllUser();


}
