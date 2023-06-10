package com.github.youssfbr.cursomc.services;

import com.github.youssfbr.cursomc.dtos.ClientResponseAllDTO;
import com.github.youssfbr.cursomc.dtos.ClientResponseDTO;
import com.github.youssfbr.cursomc.entities.Client;
import com.github.youssfbr.cursomc.repositories.IClientRepository;
import com.github.youssfbr.cursomc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.cursomc.services.interfaces.IClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponseAllDTO> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseAllDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDTO getById(Long id) {
        Client entity = findProductById(id);
        return new ClientResponseDTO(entity);
    }

    private Client findProductById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found."));
    }

}
