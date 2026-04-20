package com.ijse.food_ordering.services;

import com.ijse.food_ordering.dto.AuthResponse;
import com.ijse.food_ordering.dto.SignInRequest;
import com.ijse.food_ordering.dto.SignUpRequest;

public interface AuthService {
    AuthResponse signUp(SignUpRequest request);
    AuthResponse signIn(SignInRequest request);
}