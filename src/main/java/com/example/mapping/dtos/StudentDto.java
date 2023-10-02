package com.example.mapping.dtos;
import lombok.Builder;

@Builder
public record StudentDto(Long id_Students,
                         String name,
                         String email,
                         String semester,
                         String career){
    }


