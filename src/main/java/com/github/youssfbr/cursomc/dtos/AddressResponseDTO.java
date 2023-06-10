package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Address;

public record AddressResponseDTO(Long id, String publicPlace, String number, String complement, String district, String cep, CityResponseDTO city) {

    public AddressResponseDTO(Address address) {
        this(address.getId(), address.getPublicPlace(), address.getNumber(), address.getComplement(), address.getDistrict(), address.getCep(), new CityResponseDTO(address.getCity()));
    }
}
