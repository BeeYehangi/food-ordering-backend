package com.ijse.food_ordering.services;

import com.ijse.food_ordering.dto.CartItemRequest;
import com.ijse.food_ordering.entities.Cart;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, CartItemRequest request);
    Cart updateCartItem(Long userId, Long cartItemId, Integer quantity);
    void removeCartItem(Long userId, Long cartItemId);
    void clearCart(Long userId);
}