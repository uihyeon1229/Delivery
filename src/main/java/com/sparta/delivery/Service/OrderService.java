package com.sparta.delivery.Service;

import com.sparta.delivery.Dto.FoodOrderDto;
import com.sparta.delivery.Dto.FoodOrderRequestDto;
import com.sparta.delivery.Dto.OrderDto;
import com.sparta.delivery.Dto.OrderRequestDto;
import com.sparta.delivery.Models.Food;
import com.sparta.delivery.Models.FoodOrder;
import com.sparta.delivery.Models.Orders;
import com.sparta.delivery.Models.Restaurant;
import com.sparta.delivery.Repository.FoodOrderRepository;
import com.sparta.delivery.Repository.FoodRepository;
import com.sparta.delivery.Repository.OrdersRepository;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final OrdersRepository ordersRepository;


    public OrderDto registerOrder(OrderRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("음식점 정보가 존재하지 않습니다.")
        );

        String restaurantName = restaurant.getName();
        Long deliveryFee = restaurant.getDeliveryFee();
        Long totalPrice = 0L;

        //응답 보내기 위한 List

        List<FoodOrderDto> FoodOrderDto = new ArrayList<>();

        //DB 저장하기 위한 List
        List<FoodOrder> FoodOrderList = new ArrayList<>();

        for (FoodOrderRequestDto foodOrderRequestDto : requestDto.getFoods()) {
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElseThrow(
                    () -> new IllegalArgumentException("음식 정보가 존재하지 않습니다.")
            );

            Long quantity = foodOrderRequestDto.getQuantity();

            if(quantity < 1 || quantity>100){
                throw new IllegalArgumentException(" 음식 주문 수량오류");
            }

            //foodOrder에 food(name,price,restaurantId)와 quantity 저장 (DB용)
            FoodOrder foodOrder = new FoodOrder(food, quantity);

            FoodOrderList.add(foodOrder);

            foodOrderRepository.save(foodOrder);

            totalPrice += foodOrder.getPrice();

            //----------------------------------------------------------------------------

            FoodOrderDto foodOrderDto = new FoodOrderDto(food.getName(), quantity, foodOrder.getPrice());


            FoodOrderDto.add(foodOrderDto);
        }
        if(totalPrice< restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("최소 주문 금액오류");
        }

        totalPrice += deliveryFee;

            Orders orders = new Orders(restaurantName,deliveryFee,totalPrice,FoodOrderList);

            OrderDto orderDto = new OrderDto(restaurantName, FoodOrderDto, deliveryFee, totalPrice);

            ordersRepository.save(orders);

            return orderDto;

        }

        public List<Orders> getOrders(){
        List<Orders> orders = ordersRepository.findAll();
//        List<OrderDto> orderList = new ArrayList<>();
//
//
//        for(Orders orders1 : orders){
//            String restaurantName = orders1.getRestaurantName();
//            Long deliveryFee = orders1.getDeliveryFee();
//            Long totalPrice = orders1.getTotalPrice();
//
//            List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
//
//            for(FoodOrder foodOrder : orders1.getFoodOrders()){
//                String name = foodOrder.getName();
//                Long quantity = foodOrder.getQuantity();
//                Long price = foodOrder.getPrice();
//
//                FoodOrderDto foodOrderDto = new FoodOrderDto(name, quantity, price);
//                foodOrderDtoList.add(foodOrderDto);
//            }
//            OrderDto orderDto2 = new OrderDto(restaurantName, foodOrderDtoList, deliveryFee, totalPrice);
//            orderList.add(orderDto2);
//        }
        return orders;

        }



}
