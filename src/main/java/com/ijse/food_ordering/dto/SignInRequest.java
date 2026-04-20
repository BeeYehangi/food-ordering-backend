package com.ijse.food_ordering.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignInRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}