package com.raphael.usersystem.dtos.request;

import com.raphael.usersystem.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private Address address;



}
