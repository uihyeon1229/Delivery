package com.sparta.delivery.Service;

import com.sparta.delivery.Dto.FoodDto;
import com.sparta.delivery.Models.Food;
import com.sparta.delivery.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> foodDto) {

        for (FoodDto foodDto2 : foodDto) {

            if (foodDto2.getPrice() < 100 || foodDto2.getPrice() > 1000000) {
                throw new IllegalArgumentException("음식가격 범위오류");
            }

            if (foodDto2.getPrice() % 100 != 0) {
                throw new IllegalArgumentException("음식가격 단위오류");
            }

            List<Food> foodList = foodRepository.findByRestaurantIdAndName(restaurantId, foodDto2.getName());
            if (foodList.size() > 0){
                throw new IllegalArgumentException("음식명 중복");
            }

            foodRepository.save(new Food(foodDto2,restaurantId));
        }
    }
    public List<Food> showAllFood(Long restaurantId){
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}
