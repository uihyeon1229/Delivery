package com.sparta.delivery.Service;

import com.sparta.delivery.Dto.RestaurantDto;
import com.sparta.delivery.Models.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository =restaurantRepository;
    }


    public Restaurant registerRestaurant(RestaurantDto restaurantDto){

        //    1. 허용값: 1,000원 ~ 100,000원 입력
        if(restaurantDto.getMinOrderPrice()<1000 || restaurantDto.getMinOrderPrice()>100000){
            throw new IllegalArgumentException("주문가격 오류");}

        //    2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
        if(restaurantDto.getMinOrderPrice() % 100 !=0){
            throw new IllegalArgumentException("주문단위 오류");}

        //3. 기본 배달비 (deliveryFee)
        // 3.1 허용값: 0원 ~ 10,000원
        if(restaurantDto.getDeliveryFee()<0 || restaurantDto.getDeliveryFee()>10000){
            throw new IllegalArgumentException("배달비 오류");}

        // 3.2 500원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능)
        if(restaurantDto.getDeliveryFee() % 500 !=0){
            throw new IllegalArgumentException("배달비 단위 오류");}


        return restaurantRepository.save(new Restaurant(restaurantDto));
    }

    public List<Restaurant> showAllRestaurant(){
        return restaurantRepository.findAll();
    }
}
