package com.github.youssfbr.cursomc.dtos;

import java.util.List;

public record ClienteRequestNewDTO(
        String name,
        String email,
        String cpfOrCnpj,
        Integer clientStatus,


        List<PhoneRequestDTO> phones,
        List<AddressRequestDTO> addresses

) {
}
