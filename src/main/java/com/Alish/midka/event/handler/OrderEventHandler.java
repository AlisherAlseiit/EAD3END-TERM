package com.Alish.midka.event.handler;

import com.Alish.midka.event.OrderEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler implements ApplicationListener<OrderEvent> {


    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("User with id: " + orderEvent.getUserId() + " bought product with id: " + orderEvent.getProductId());
    }
}
