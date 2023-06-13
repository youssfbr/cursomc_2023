package com.github.youssfbr.cursomc.services.interfaces;

import com.github.youssfbr.cursomc.dtos.OrderResponseDTO;

public interface IOrderService {
    OrderResponseDTO getById(Long id);

}
