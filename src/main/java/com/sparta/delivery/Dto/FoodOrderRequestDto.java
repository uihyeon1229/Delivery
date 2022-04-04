package com.sparta.delivery.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodOrderRequestDto {
    Long id;
    Long quantity;
}