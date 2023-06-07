package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Category;
import com.github.youssfbr.cursomc.entities.Product;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products = new ArrayList<>();

    public CategoryDTO(Category entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public CategoryDTO(Category entity, List<Product> products) {

        this(entity);

        products.forEach(x -> this.products.add(new ProductDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

}
