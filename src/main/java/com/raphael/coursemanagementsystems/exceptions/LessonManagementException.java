package com.raphael.coursemanagementsystems.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LessonManagementException extends RuntimeException {
    public LessonManagementException(String message) {
    }
}
