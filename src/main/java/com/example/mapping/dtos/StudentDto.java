package com.example.mapping.dtos;

import com.example.domain.enums.Career;

public record StudentDto(Long id_Students,
                         String name,
                         String email,
                         String semester,
                         Career career){

}
