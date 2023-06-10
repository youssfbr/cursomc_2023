package com.github.youssfbr.cursomc.repositories;

import com.github.youssfbr.cursomc.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
