package com.ijse.food_ordering.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequest {
    @NotBlank
    private String deliveryAddress;
}