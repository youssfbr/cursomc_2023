package com.github.youssfbr.cursomc.services;

import com.github.youssfbr.cursomc.dtos.OrderResponseDTO;
import com.github.youssfbr.cursomc.entities.Order;
import com.github.youssfbr.cursomc.repositories.IOrderRepository;
import com.github.youssfbr.cursomc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.cursomc.services.interfaces.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IOrderService {

    private IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDTO getById(Long id) {

        Order entity = findOrderById(id);

        return new OrderResponseDTO(entity);
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found."));
    }
}
