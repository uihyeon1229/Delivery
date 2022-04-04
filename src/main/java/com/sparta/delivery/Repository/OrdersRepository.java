package com.sparta.delivery.Repository;

import com.sparta.delivery.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <Orders, Long>{
}
