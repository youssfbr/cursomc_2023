package com.github.youssfbr.cursomc.controllers;

import com.github.youssfbr.cursomc.dtos.ClientResponseAllDTO;
import com.github.youssfbr.cursomc.dtos.ClientResponseDTO;
import com.github.youssfbr.cursomc.services.interfaces.IClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientResponseAllDTO> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

}
