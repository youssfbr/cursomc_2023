package com.github.youssfbr.cursomc.services.interfaces;

import com.github.youssfbr.cursomc.dtos.CategoryDTO;
import com.github.youssfbr.cursomc.dtos.CategoryRequestDTO;
import com.github.youssfbr.cursomc.dtos.CategoryResponseAllDTO;
import com.github.youssfbr.cursomc.dtos.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<CategoryResponseAllDTO> getAll();
    Page<CategoryResponseAllDTO> getAllPaged(PageRequest pageRequest);
    CategoryResponseDTO getById(Long id);
    CategoryDTO insert(CategoryRequestDTO dto);
    CategoryDTO update(Long id, CategoryRequestDTO dto);
    void delete(Long id);

}
