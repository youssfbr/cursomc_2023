package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Client;

public record ClientResponseAllDTO(Long id, String name, String email, String cpfOrCnpj, Integer clientStatus) {
    public ClientResponseAllDTO(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getCpfOrCnpj(), client.getClientStatus().getId());
    }
}




