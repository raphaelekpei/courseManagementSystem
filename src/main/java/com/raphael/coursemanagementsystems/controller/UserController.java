package com.raphael.coursemanagementsystems.controller;


import com.raphael.coursemanagementsystems.data.model.User;
import com.raphael.coursemanagementsystems.dtos.request.LoginRequest;
import com.raphael.coursemanagementsystems.dtos.request.SignUpRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateUserRequest;
import com.raphael.coursemanagementsystems.dtos.response.LoginResponse;
import com.raphael.coursemanagementsystems.dtos.response.SignUpResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateUserResponse;

import java.util.List;

public interface UserController {
    public SignUpResponse addUser(SignUpRequest signUpRequest);
    public LoginResponse loginUser(LoginRequest loginRequest);

    public User getUserById(String userId);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public User getUserByPhoneNumber(String phoneNumber);
    public List<User> getAllUser();

    public UpdateUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest);

    public String deleteUserById(String userId);
    public String deleteAllUser();
}
