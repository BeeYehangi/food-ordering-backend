package com.ijse.food_ordering.repositories;

import com.ijse.food_ordering.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}