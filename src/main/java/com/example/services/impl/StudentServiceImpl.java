package com.example.services.impl;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.impl.StudentRepositoryImpl;
import com.example.repository.impl.StudentRepositoryLogicImpl;
import com.example.services.StudentsService;

import java.util.List;

public class StudentServiceImpl implements StudentsService {
    private final StudentRepositoryImpl repository;

    public StudentServiceImpl(StudentRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<StudentDto> listar() {
        return repository.list();
    }

    @Override
    public StudentDto porId(Long id) {
        return repository.byId(id);
    }

    @Override
    public void guardar(StudentDto t) {
         repository.update(t);
    }

    @Override
    public void eliminar(Long id) {
        repository.delete(id);
    }
}
