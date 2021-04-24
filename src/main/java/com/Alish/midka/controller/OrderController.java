package com.Alish.midka.controller;

import com.Alish.midka.Service.OrderService;
import com.Alish.midka.exception.ApiRequestException;
import com.Alish.midka.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public void buyProduct(@RequestParam Long productId, Long userId){
        if(userId == 0 || productId == 0){
            throw new ApiRequestException("userId or productId cannot be null or equal to 0");
        }

        orderService.createOrder(productId, userId);
    }

}
