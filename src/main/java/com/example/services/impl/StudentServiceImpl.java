package com.example.services.impl;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.impl.StudentRepositoryLogicImpl;
import com.example.services.StudentsService;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor



public class StudentServiceImpl implements StudentsService {
    StudentRepositoryLogicImpl repo = new StudentRepositoryLogicImpl();

    public StudentServiceImpl(StudentRepositoryLogicImpl repository) {
        this.repo = repository;
    }
    @Override
    public List<StudentDto> list() {
        return repo.list();
    }

    @Override
    public StudentDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(StudentDto student) {
        repo.update(student);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}