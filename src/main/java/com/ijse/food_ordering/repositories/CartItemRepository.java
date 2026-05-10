package com.ijse.food_ordering.repositories;

import com.ijse.food_ordering.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
    @Modifying
    @Transactional
    @Query("DELETE FROM CartItem ci WHERE ci.id = :cartItemId")
    void deleteByCartItemId(Long cartItemId);
}