package com.example.services;

import com.example.mapping.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> list();

    StudentDto byId(Long id);

    void update(StudentDto student);

    void delete(Long id);
}
