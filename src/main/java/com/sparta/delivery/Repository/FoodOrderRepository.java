package com.sparta.delivery.Repository;

import com.sparta.delivery.Models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository <FoodOrder, Long>{
}
