package com.ijse.food_ordering.controllers;

import com.ijse.food_ordering.dto.FoodItemRequest;
import com.ijse.food_ordering.entities.FoodItem;
import com.ijse.food_ordering.services.FoodItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping
    public ResponseEntity<FoodItem> create(@Valid @RequestBody FoodItemRequest request) {
        return ResponseEntity.ok(foodItemService.createFoodItem(request));
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> getAll() {
        return ResponseEntity.ok(foodItemService.getAllFoodItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getById(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.getFoodItemById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<FoodItem>> getByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(foodItemService.getFoodItemsByCategory(categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> update(@PathVariable Long id,
                                           @Valid @RequestBody FoodItemRequest request) {
        return ResponseEntity.ok(foodItemService.updateFoodItem(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
}