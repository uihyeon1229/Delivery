package com.sparta.delivery.Controller;

import com.sparta.delivery.Dto.OrderDto;
import com.sparta.delivery.Dto.OrderRequestDto;
import com.sparta.delivery.Models.Orders;
import com.sparta.delivery.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderDto registerOrder(@RequestBody OrderRequestDto requestDto){
        return orderService.registerOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

}
