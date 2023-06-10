package com.github.youssfbr.cursomc.services.interfaces;

import com.github.youssfbr.cursomc.dtos.CategoryDTO;
import com.github.youssfbr.cursomc.dtos.CategoryRequestDTO;
import com.github.youssfbr.cursomc.dtos.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAll();
    Page<CategoryDTO> getAllPaged(PageRequest pageRequest);
    CategoryResponseDTO getById(Long id);
    CategoryDTO insert(CategoryRequestDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);

}
