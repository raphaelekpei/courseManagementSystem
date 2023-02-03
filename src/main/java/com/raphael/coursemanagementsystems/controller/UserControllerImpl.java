package com.raphael.coursemanagementsystems.controller;

import com.raphael.coursemanagementsystems.data.model.User;
import com.raphael.coursemanagementsystems.dtos.request.LoginRequest;
import com.raphael.coursemanagementsystems.dtos.request.SignUpRequest;
import com.raphael.coursemanagementsystems.dtos.request.UpdateUserRequest;
import com.raphael.coursemanagementsystems.dtos.response.LoginResponse;
import com.raphael.coursemanagementsystems.dtos.response.SignUpResponse;
import com.raphael.coursemanagementsystems.dtos.response.UpdateUserResponse;
import com.raphael.coursemanagementsystems.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Validated
public class UserControllerImpl implements UserController{
    @Autowired
    private final UserService userService;

    @Override
    @PostMapping("/signup")
    public SignUpResponse addUser(@RequestBody @Valid SignUpRequest signUpRequest) {
        return userService.addUser(signUpRequest);
    }

    @Override
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @Override
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @Override
    @GetMapping("/user/email")
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    @GetMapping("/user/username")
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    @GetMapping("/user/phone-number")
    public User getUserByPhoneNumber(String phoneNumber) {
        return userService.getUserByPhoneNumber(phoneNumber);
    }


    @Override
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }


    @Override
    @PutMapping("/update/{userId}")
    public UpdateUserResponse updateUser(@PathVariable String userId, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        return userService.updateUser(userId, updateUserRequest);
    }

    @Override
    @DeleteMapping("delete/{userId}")
    public String deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return "deleted successfully";
    }

    @Override
    @DeleteMapping("delete/all")
    public String deleteAllUser() {
        userService.deleteAllUser();
        return "all deleted successfully";
    }
}
