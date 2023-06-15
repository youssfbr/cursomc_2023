package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Category;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record CategoryRequestDTO(
        @NotEmpty(message = "Preenchimento obrigatório.")
        @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres.")
        String name) {

    public CategoryRequestDTO(Category category) {
        this(category.getName());
    }
}


