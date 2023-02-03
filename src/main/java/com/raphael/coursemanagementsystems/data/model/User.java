package com.raphael.coursemanagementsystems.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    private String userId;
    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "first name cannot be blank")
    private String lastName;
    @NotBlank(message = "email cannot be blank")
    @Email
    private String email;

    @NotBlank
    private String username;

    @NotNull
    private String password;

    @NotBlank(message = "Address name cannot be blank")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @NotBlank(message = "this field cannot be empty")
    private String nationality;

    @NotBlank(message = "first name cannot be blank")
    @Pattern(regexp = "\"^(?:(?:(?:\\\\+?234(?:\\\\h1)?|01)\\\\h*)?(?:\\\\(\\\\d{3}\\\\)|\\\\d{3})|\\\\d{4})(?:\\\\W*\\\\d{3})?\\\\W*\\\\d{4}$\n")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Subject> subjectList = new ArrayList<>();


    public User(String firstName, String lastName, String email, String username, String password, Address address, String phoneNumber, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
    }
}
