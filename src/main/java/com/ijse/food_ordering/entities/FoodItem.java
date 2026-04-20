package com.ijse.food_ordering.entities;

import com.ijse.food_ordering.enums.FoodItemStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "food_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private FoodItemStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}