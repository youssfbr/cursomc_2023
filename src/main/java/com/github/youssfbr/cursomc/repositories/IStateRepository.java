package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStateRepository extends JpaRepository<State, Long> {
}
