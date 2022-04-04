package com.sparta.delivery.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private Long deliveryFee;
    private Long totalPrice;

    public OrderDto(String restaurantName, List<FoodOrderDto> foodOrderDto, Long deliveryFee, Long totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foodOrderDto;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }


}