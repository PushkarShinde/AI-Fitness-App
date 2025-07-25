package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//What are we going to accept from the user as a part of the request
@Data
public class RegisterRequest {
    @NotBlank(message="Email is required")
    @Email(message="Invalid email format")
    private String email;

    @NotBlank(message = "Password if required")
    @Size(min=6, message = "Password must be at least 6 characters")
    private String password;
    private String firstName;
    private String lastName;
}
