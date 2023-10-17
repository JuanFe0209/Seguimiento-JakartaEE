package com.example.services.impl;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.Repository;
import com.example.services.StudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService{
    @Inject
    @Named("defaultRepository")
    private Repository<StudentDto> repo;

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
