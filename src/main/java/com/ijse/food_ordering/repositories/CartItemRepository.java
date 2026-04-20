package com.ijse.food_ordering.repositories;

import com.ijse.food_ordering.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}