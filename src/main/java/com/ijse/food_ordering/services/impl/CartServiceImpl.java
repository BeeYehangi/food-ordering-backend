package com.ijse.food_ordering.services.impl;

import com.ijse.food_ordering.dto.CartItemRequest;
import com.ijse.food_ordering.entities.*;
import com.ijse.food_ordering.exceptions.ResourceNotFoundException;
import com.ijse.food_ordering.repositories.*;
import com.ijse.food_ordering.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final FoodItemRepository foodItemRepository;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUser_Id(userId)
                .orElseGet(() -> createCartForUser(userId));
    }

    @Override
    public Cart addItemToCart(Long userId, CartItemRequest request) {
        Cart cart = getCartByUserId(userId);
        FoodItem foodItem = foodItemRepository.findById(request.getFoodItemId())
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found"));


        CartItem cartItem = CartItem.builder()
                .cart(cart)
                .foodItem(foodItem)
                .quantity(request.getQuantity())
                .build();

        cartItemRepository.save(cartItem);
        cart.getCartItems().add(cartItem);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCartItem(Long userId, Long cartItemId, Integer quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
        return getCartByUserId(userId);
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartItemRepository.deleteAll(cart.getCartItems());
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

    private Cart createCartForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Cart cart = Cart.builder()
                .user(user)
                .cartItems(new ArrayList<>())
                .build();
        return cartRepository.save(cart);
    }
}