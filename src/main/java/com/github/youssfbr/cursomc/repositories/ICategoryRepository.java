package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
