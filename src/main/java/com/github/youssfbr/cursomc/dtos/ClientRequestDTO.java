package com.github.youssfbr.cursomc.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ClientRequestDTO(
        Long id,
        @NotEmpty(message = "Preenchimento obrigatório.")
        @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres.")
        String name,

        @NotEmpty(message = "Preenchimento obrigatório.")
        @Email(message = "e-mail inválido.")
        String email,

        String cpfOrCnpj,

        @NotNull(message = "Preenchimento obrigatório.")
        Integer clientStatus

) {

}
