package com.github.youssfbr.cursomc.controllers;

import com.github.youssfbr.cursomc.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public List<Category> list() {

        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1L, "Informática"));
        categories.add(new Category(2L, "Escritório"));

        return categories;
    }

}
