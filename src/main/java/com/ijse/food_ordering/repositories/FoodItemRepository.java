package com.ijse.food_ordering.repositories;

import com.ijse.food_ordering.entities.FoodItem;
import com.ijse.food_ordering.enums.FoodItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByCategory_Id(Long categoryId);
    List<FoodItem> findByStatus(FoodItemStatus status);
}