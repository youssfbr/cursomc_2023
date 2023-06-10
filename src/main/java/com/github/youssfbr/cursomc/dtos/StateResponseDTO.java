package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.State;

public record StateResponseDTO(Long id, String name) {

    public StateResponseDTO(State state) {
        this(state.getId(), state.getName());
    }

}
