package com.ijse.food_ordering.services.impl;

import com.ijse.food_ordering.dto.FoodItemRequest;
import com.ijse.food_ordering.entities.*;
import com.ijse.food_ordering.enums.FoodItemStatus;
import com.ijse.food_ordering.exceptions.ResourceNotFoundException;
import com.ijse.food_ordering.repositories.*;
import com.ijse.food_ordering.services.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public FoodItem createFoodItem(FoodItemRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        FoodItem item = FoodItem.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .status(FoodItemStatus.AVAILABLE)
                .category(category)
                .build();

        return foodItemRepository.save(item);
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @Override
    public List<FoodItem> getFoodItemsByCategory(Long categoryId) {
        return foodItemRepository.findByCategory_Id(categoryId);
    }

    @Override
    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found"));

    }

    @Override
    public FoodItem updateFoodItem(Long id, FoodItemRequest request) {
        FoodItem item = getFoodItemById(id);
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        item.setImageUrl(request.getImageUrl());
        item.setCategory(category);

        return foodItemRepository.save(item);
    }

    @Override
    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}