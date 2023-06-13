package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
