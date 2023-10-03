package com.example.services.impl;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.Repository;
import com.example.repository.impl.StudentRepositoryImpl;
import com.example.repository.impl.StudentRepositoryLogicImpl;
import com.example.services.StudentService;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.util.List;
@NoArgsConstructor



public class StudentServiceImpl implements StudentService {

    private Repository<StudentDto> repo;
    public StudentServiceImpl(Connection connection) {
        this.repo = new StudentRepositoryImpl(connection);
    }

    public StudentServiceImpl(StudentRepositoryImpl repository) {
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