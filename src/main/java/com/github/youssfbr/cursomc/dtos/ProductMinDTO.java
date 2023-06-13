package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Product;

public record ProductMinDTO (Long id, String name, Double price) {

    public ProductMinDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }

}
