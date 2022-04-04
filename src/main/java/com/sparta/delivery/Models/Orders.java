package com.sparta.delivery.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private Long deliveryFee;

    @Column(nullable = false)
    private Long totalPrice;

    @OneToMany
    @JoinColumn
    private List<FoodOrder> foods;

    public Orders(String restaurantName, Long deliveryFee, Long totalPrice, List<FoodOrder> foodOrderList) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.foods = foodOrderList;
    }
}
