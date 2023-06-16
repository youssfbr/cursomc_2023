package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Client;

import java.util.List;

public record ClientResponseDTO(
        Long id,
        String name,
        String email,
        String cpfOrCnpj,
        String clientStatus,
        List<AddressResponseDTO> addresses,
        List<PhoneResponseDTO> phones) {

    public ClientResponseDTO(Client client) {
        this(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getCpfOrCnpj(),
                client.getClientStatus().getDescription(),

                client.getAddresses()
                        .stream()
                        .map(AddressResponseDTO::new)
                        .toList(),

                client.getPhones()
                        .stream()
                        .map(PhoneResponseDTO::new)
                        .toList());
    }

}




