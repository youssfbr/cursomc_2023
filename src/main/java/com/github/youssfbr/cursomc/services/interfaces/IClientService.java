package com.github.youssfbr.cursomc.services.interfaces;

import com.github.youssfbr.cursomc.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IClientService {

    List<ClientResponseAllDTO> getAll();
    Page<ClientResponseAllDTO> getAllPaged(PageRequest pageRequest);
    ClientResponseDTO getById(Long id);
    ClientResponseDTO update(Long id, ClientRequestDTO dto);
    void delete(Long id);

}
