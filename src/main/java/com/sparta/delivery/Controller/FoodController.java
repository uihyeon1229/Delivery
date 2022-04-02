package com.sparta.delivery.Controller;

import com.sparta.delivery.Dto.FoodDto;
import com.sparta.delivery.Models.Food;
import com.sparta.delivery.Repository.FoodRepository;
import com.sparta.delivery.Repository.RestaurantRepository;
import com.sparta.delivery.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto){

//        restaurantRepository.findById(restaurantId).orElseThrow(
//                () -> new IllegalArgumentException("null")
//        );
//        Food food = new Food(foodDto);
//
//        return food;
        foodService.registerFood(restaurantId, foodDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showAllFood(@PathVariable Long restaurantId){

        return foodService.showAllFood(restaurantId);
    }
}
