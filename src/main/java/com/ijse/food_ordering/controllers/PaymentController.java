package com.ijse.food_ordering.controllers;

import com.ijse.food_ordering.entities.Payment;
import com.ijse.food_ordering.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{orderId}")
    public ResponseEntity<Payment> processPayment(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.processPayment(orderId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
    }
}