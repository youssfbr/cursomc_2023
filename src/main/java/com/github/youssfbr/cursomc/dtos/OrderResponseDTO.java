package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Order;

import java.time.Instant;
import java.util.List;

public record OrderResponseDTO(Long id, Instant instant, PaymentResponseDTO payment, ClientResponseDTO client, AddressResponseDTO deliveryAddress, List<OrderItemResponseDTO> itens) {

    public OrderResponseDTO(Order order) {
        this(order.getId(), order.getInstant(),
                new PaymentResponseDTO(order.getPayment()),
                new ClientResponseDTO(order.getClient()),
                new AddressResponseDTO(order.getDeliveryAddress()),
                order.getOrderItems()
                        .stream()
                        .map(OrderItemResponseDTO::new)
                        .toList());
    }

}
