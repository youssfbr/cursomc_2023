package com.github.youssfbr.cursomc.services.interfaces;

import com.github.youssfbr.cursomc.dtos.ClientResponseAllDTO;
import com.github.youssfbr.cursomc.dtos.ClientResponseDTO;

import java.util.List;

public interface IClientService {

    List<ClientResponseAllDTO> getAll();
    ClientResponseDTO getById(Long id);

}
