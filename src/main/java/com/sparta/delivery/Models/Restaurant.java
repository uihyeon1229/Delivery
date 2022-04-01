package com.sparta.delivery.Models;

import com.sparta.delivery.Dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

//    public Restaurant(String name, Long minOrderPrice, Long deliveryFee){
//        this.name = name;
//        this.minOrderPrice = minOrderPrice;
//        this.deliveryFee = deliveryFee;
//    }

    public Restaurant(RestaurantDto requestDto) {

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();

    }

}
