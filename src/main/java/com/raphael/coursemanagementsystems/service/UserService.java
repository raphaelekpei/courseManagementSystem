package com.raphael.usersystem.service;

import com.raphael.usersystem.data.model.Address;
import com.raphael.usersystem.data.model.User;
import com.raphael.usersystem.dtos.request.LoginRequest;
import com.raphael.usersystem.dtos.request.SignUpRequest;
import com.raphael.usersystem.dtos.request.UpdateUserRequest;
import com.raphael.usersystem.dtos.response.LoginResponse;
import com.raphael.usersystem.dtos.response.SignUpResponse;
import com.raphael.usersystem.dtos.response.UpdateUserResponse;

import java.util.List;

public interface UserService {
    SignUpResponse addUser(SignUpRequest signUpRequest);
    LoginResponse loginUser(LoginRequest loginRequest);

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    User getUserByPhoneNumber(String phoneNumber);

    User getUserById(String userId);

    List<User> getAllUser();

    void updateUser(String userId, String firstName, String lastName, String phoneNumber, String password, Address address);

    void deleteUserById(String userId);

    void deleteAllUser();

    UpdateUserResponse updateUser(String userId, UpdateUserRequest updateUserRequest);

}
