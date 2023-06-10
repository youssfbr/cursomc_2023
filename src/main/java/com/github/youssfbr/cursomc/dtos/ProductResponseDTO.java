package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Product;

import java.time.Instant;

public record ProductResponseDTO(Long id, String name, String description, Double price, String imgUrl, Instant date) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl(), product.getDate());
    }
}
