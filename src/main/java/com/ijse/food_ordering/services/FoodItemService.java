package com.ijse.food_ordering.services;

import com.ijse.food_ordering.dto.FoodItemRequest;
import com.ijse.food_ordering.entities.FoodItem;
import java.util.List;

public interface FoodItemService {
    FoodItem createFoodItem(FoodItemRequest request);
    List<FoodItem> getAllFoodItems();
    List<FoodItem> getFoodItemsByCategory(Long categoryId);
    FoodItem getFoodItemById(Long id);
    FoodItem updateFoodItem(Long id, FoodItemRequest request);
    void deleteFoodItem(Long id);
}