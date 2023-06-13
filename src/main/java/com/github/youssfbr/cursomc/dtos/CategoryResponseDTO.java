package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Category;

import java.util.List;

public record CategoryResponseDTO(Long id, String name, List<ProductMinDTO> products) {

    public CategoryResponseDTO(Category category) {
        this(
                category.getId(),
                category.getName(),
                category.getProducts()
                        .stream()
                        .map(ProductMinDTO::new)
                        .toList());
    }

}
