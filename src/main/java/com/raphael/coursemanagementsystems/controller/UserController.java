package com.raphael.usersystem.controller;

import com.raphael.usersystem.data.model.Address;
import com.raphael.usersystem.data.model.User;
import com.raphael.usersystem.dtos.request.LoginRequest;
import com.raphael.usersystem.dtos.request.SignUpRequest;
import com.raphael.usersystem.dtos.request.UpdateUserRequest;
import com.raphael.usersystem.dtos.response.LoginResponse;
import com.raphael.usersystem.dtos.response.SignUpResponse;
import com.raphael.usersystem.dtos.response.UpdateUserResponse;

import java.util.List;

public interface UserController {
    public SignUpResponse addUser(SignUpRequest signUpRequest);
    public LoginResponse loginUser(LoginRequest loginRequest);

    public User getUserById(String userId);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public User getUserByPhoneNumber(String phoneNumber);
    public List<User> getAllUser();

    public String updateUser(String userId, String firstName, String lastName, String email,
                             String phoneNumber, String password, Address address);
    public UpdateUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest);

    public String deleteUserById(String userId);
    public String deleteAllUser();
}
