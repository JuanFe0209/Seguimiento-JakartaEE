package com.example.services.impl;

import com.example.mapping.dtos.GradeDto;
import com.example.repository.impl.GradeRepositoryImpl;
import com.example.services.GradesService;

import java.util.List;


public class GradeServiceImpl implements GradesService {
    GradeRepositoryImpl repo = new GradeRepositoryImpl();
    @Override
    public List<GradeDto> list() {
        return repo.list();
    }

    @Override
    public GradeDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(GradeDto grades) {
        repo.update(grades);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}