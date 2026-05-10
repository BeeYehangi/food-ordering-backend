package com.ijse.food_ordering.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import jakarta.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    private Integer quantity;

    private BigDecimal price;
}