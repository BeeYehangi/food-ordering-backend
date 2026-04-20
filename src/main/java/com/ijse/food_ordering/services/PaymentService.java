package com.ijse.food_ordering.services;

import com.ijse.food_ordering.entities.Payment;

public interface PaymentService {
    Payment processPayment(Long orderId);
    Payment getPaymentByOrderId(Long orderId);
}