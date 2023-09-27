package com.example.services;

import com.example.mapping.dtos.GradeDto;

import java.util.List;

public interface GradeService {
    List<GradeDto> list();

    GradeDto byId(Long id);

    void update(GradeDto grades);

    void delete(Long id);
}
