package com.Alish.midka.Service;

import com.Alish.midka.model.Order;
import com.Alish.midka.model.Product;
import com.Alish.midka.model.User;
import com.Alish.midka.repository.OrderRepository;
import com.Alish.midka.repository.ProductRepository;
import com.Alish.midka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void createOrder(Long productId, Long userId){
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);


        if (product != null && user != null) {
            Order order = new Order();
            order.setProductId(productId);
            order.setUserId(userId);
            orderRepository.saveAndFlush(order);
        }
    }
}

















