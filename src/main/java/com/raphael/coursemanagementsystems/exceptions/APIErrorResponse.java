package com.raphael.coursemanagementsystems.exceptions;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIErrorResponse {
    private Boolean isSuccessful;
    private String message;
    private LocalDateTime timeStamp;
}
