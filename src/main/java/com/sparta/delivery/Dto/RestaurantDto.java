package com.sparta.delivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;
}
