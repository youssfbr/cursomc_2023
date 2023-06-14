package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Category;

public record CategoryResponseAllDTO(Long id, String name) {

    public CategoryResponseAllDTO(Category category) {
        this(
                category.getId(),
                category.getName());
    }
}
