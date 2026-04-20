package com.ijse.food_ordering.services;

import com.ijse.food_ordering.entities.Order;
import com.ijse.food_ordering.enums.OrderStatus;
import java.util.List;

public interface OrderService {
    Order placeOrder(Long userId);
    List<Order> getOrdersByUserId(Long userId);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order updateOrderStatus(Long id, OrderStatus status);
}