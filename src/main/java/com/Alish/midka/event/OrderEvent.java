package com.Alish.midka.event;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {
    private Long userId;
    private Long productId;

    public OrderEvent(Object source, Long userId, Long productId) {
        super(source);
        this.userId = userId;
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }
}
