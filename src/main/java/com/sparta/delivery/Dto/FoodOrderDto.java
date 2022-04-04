package com.sparta.delivery.Dto;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    String name;
    Long quantity;
    Long price;

    public FoodOrderDto(String name, Long quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
