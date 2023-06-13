package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.OrderItem;

public record OrderItemResponseDTO(Double discount, Integer quantity, Double price, ProductMinDTO product) {

    public OrderItemResponseDTO(OrderItem orderItem) {
        this(orderItem.getDiscount(), orderItem.getQuantity(), orderItem.getPrice(), new ProductMinDTO(orderItem.getProduct()));
    }


}
