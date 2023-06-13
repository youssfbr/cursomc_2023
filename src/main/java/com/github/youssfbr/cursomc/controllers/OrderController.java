package com.github.youssfbr.cursomc.controllers;

import com.github.youssfbr.cursomc.dtos.OrderResponseDTO;
import com.github.youssfbr.cursomc.services.interfaces.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderResponseDTO getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

}
