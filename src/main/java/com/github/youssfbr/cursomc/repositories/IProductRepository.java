package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
