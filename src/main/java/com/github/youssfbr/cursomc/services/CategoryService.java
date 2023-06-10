package com.github.youssfbr.cursomc.services;

import com.github.youssfbr.cursomc.dtos.CategoryDTO;
import com.github.youssfbr.cursomc.dtos.CategoryRequestDTO;
import com.github.youssfbr.cursomc.dtos.CategoryResponseDTO;
import com.github.youssfbr.cursomc.entities.Category;
import com.github.youssfbr.cursomc.repositories.ICategoryRepository;
import com.github.youssfbr.cursomc.services.exceptions.DatabaseException;
import com.github.youssfbr.cursomc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.cursomc.services.interfaces.ICategoryService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryDTO> getAllPaged(PageRequest pageRequest) {
        return categoryRepository
                .findAll(pageRequest)
                .map(CategoryDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDTO getById(Long id) {

        Category entity = findCategoryById(id);

        return new CategoryResponseDTO(entity);
    }



    @Override
    @Transactional
    public CategoryDTO insert(CategoryRequestDTO requestDTO) {

        Category entity = categoryRepository.save(new Category(requestDTO));

        return new CategoryDTO(entity);
    }

    @Override
    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {

        Category entity = findCategoryById(id);
        entity.setName(dto.getName());

        entity = categoryRepository.save(entity);

        return new CategoryDTO(entity);
    }

    @Override
    public void delete(Long id) {
        try {
            findCategoryById(id);
            categoryRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found."));
    }

}
