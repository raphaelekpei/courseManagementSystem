package com.raphael.usersystem.dtos.request;

import com.raphael.usersystem.Enum.Gender;
import com.raphael.usersystem.data.model.Address;
import com.raphael.usersystem.data.model.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;
    private Gender gender;
    private String nationality;
    private Date dateOfBirth;



}
