package com.ijse.food_ordering.services.impl;

import com.ijse.food_ordering.entities.*;
import com.ijse.food_ordering.enums.OrderStatus;
import com.ijse.food_ordering.enums.PaymentStatus;
import com.ijse.food_ordering.exceptions.BadRequestException;
import com.ijse.food_ordering.exceptions.ResourceNotFoundException;
import com.ijse.food_ordering.repositories.*;
import com.ijse.food_ordering.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public Payment processPayment(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (paymentRepository.findByOrder_Id(orderId).isPresent()) {
            throw new BadRequestException("Payment already processed for this order");
        }

        Payment payment = Payment.builder()
                .order(order)
                .amount(order.getTotalAmount())
                .status(PaymentStatus.COMPLETED)
                .paidAt(java.time.LocalDateTime.now())
                .build();

        order.setStatus(OrderStatus.PREPARING);
        orderRepository.save(order);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrder_Id(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
    }
}