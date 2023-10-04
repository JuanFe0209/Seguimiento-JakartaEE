package com.example.services.impl;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.Repository;
import com.example.services.StudentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor
@ApplicationScoped
public class StudentServiceimpl implements StudentService {
    @Inject
    private Repository<StudentDto> studentRepository;

    @Override
    public List<StudentDto> list() {
        return studentRepository.list();
    }

    @Override
    public StudentDto byId(Long id) {
        return studentRepository.byId(id);
    }

    @Override
    public void update(StudentDto student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}