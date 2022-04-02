package com.sparta.delivery.Repository;

import com.sparta.delivery.Models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurantIdAndName(Long restaurantId, String name);
    List<Food> findAllByRestaurantId(Long restaurantId);
}
