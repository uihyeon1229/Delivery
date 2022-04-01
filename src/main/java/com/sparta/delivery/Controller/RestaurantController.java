package com.sparta.delivery.Controller;

import antlr.StringUtils;
import com.sparta.delivery.Dto.RestaurantDto;
import com.sparta.delivery.Models.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import com.sparta.delivery.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

//    @Autowired
//    public RestaurantController(RestaurantService restaurantService){
//        this.restaurantService = restaurantService;
//    }

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto restaurantDto){

        return restaurantService.registerRestaurant(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> showAllRestaurant(){

        return restaurantService.showAllRestaurant();
    }

}
