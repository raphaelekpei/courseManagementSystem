package com.raphael.coursemanagementsystems.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseManagementException extends RuntimeException {
    public CourseManagementException(String message) {
    }
}
