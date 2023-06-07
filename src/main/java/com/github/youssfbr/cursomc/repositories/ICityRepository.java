package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {
}
