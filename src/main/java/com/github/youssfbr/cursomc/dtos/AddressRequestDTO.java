package com.github.youssfbr.cursomc.dtos;

public record AddressRequestDTO(
        String publicPlace,
        String number,
        String complement,
        String district,
        String cep,
        CityRequestDTO city

) {
}
