package com.ijse.food_ordering.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartItemRequest {
    @NotNull
    private Long foodItemId;

    @Min(1)
    private Integer quantity;
}