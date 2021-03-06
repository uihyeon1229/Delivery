package com.sparta.delivery.Models;

import com.sparta.delivery.Dto.FoodDto;
import com.sparta.delivery.Dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long Price;

    @Column(nullable = false)
    private Long restaurantId;



//    public Restaurant(String name, Long minOrderPrice, Long deliveryFee){
//        this.name = name;
//        this.minOrderPrice = minOrderPrice;
//        this.deliveryFee = deliveryFee;
//    }

    public Food(FoodDto requestDto, Long restaurantId) {

        this.name = requestDto.getName();
        this.Price = requestDto.getPrice();
        this.restaurantId = restaurantId;

    }


}