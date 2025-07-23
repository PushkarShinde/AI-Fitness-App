package com.fitness.userservice.dto;
// DATA TRANSFER OBJECT (DTO)
import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDateTime;


// Whatever response that should be seen by the user, that goes here
@Data
public class UserResponse {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
