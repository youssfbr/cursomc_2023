package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Category;

public record CategoryRequestDTO(String name) {

    public CategoryRequestDTO(Category category) {
        this(category.getName());
    }
}


