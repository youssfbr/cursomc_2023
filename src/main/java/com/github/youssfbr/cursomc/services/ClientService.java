package com.github.youssfbr.cursomc.services;

import com.github.youssfbr.cursomc.dtos.*;
import com.github.youssfbr.cursomc.entities.Address;
import com.github.youssfbr.cursomc.entities.Client;
import com.github.youssfbr.cursomc.repositories.ICityRepository;
import com.github.youssfbr.cursomc.repositories.IClientRepository;
import com.github.youssfbr.cursomc.services.exceptions.DatabaseException;
import com.github.youssfbr.cursomc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.cursomc.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;
    private final ICityRepository cityRepository;

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
    public Page<ClientResponseAllDTO> getAllPaged(PageRequest pageRequest) {
        return clientRepository.findAll(pageRequest)
                .map(ClientResponseAllDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDTO getById(Long id) {
        Client entity = findById(id);
        return new ClientResponseDTO(entity);
    }

    @Override
    @Transactional
    public ClientResponseDTO create(ClienteRequestNewDTO dto) {

        Client client = new Client(dto);
        Client clientSaved = clientRepository.save(client);

        for (AddressRequestDTO y : dto.addresses()) {

            var city = cityRepository.findById(y.city().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada"));

            var address = new Address(y);
            address.setCity(city);
            address.setClient(clientSaved);

            clientSaved.getAddresses().add(address);
        }

        dto.phones().stream().map(ph -> clientSaved.getPhones().add(ph.phone())).toList();

        clientRepository.save(clientSaved);

        return new ClientResponseDTO(clientSaved);
    }

    @Override
    @Transactional
    public ClientResponseDTO update(Long id, ClientRequestDTO dtoToUpdate) {

        Client entity = findById(id);

        BeanUtils.copyProperties(dtoToUpdate, entity);
        entity.setId(id);

        Client updated = clientRepository.save(entity);

        return new ClientResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        try {
            findById(id);
            clientRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found."));
    }

}
