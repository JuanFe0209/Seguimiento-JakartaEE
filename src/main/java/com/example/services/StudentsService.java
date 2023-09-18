package com.example.services;

import com.example.mapping.dtos.StudentDto;

import java.util.List;

public interface StudentsService {
    List<StudentDto> listar();

    StudentDto porId(Long id);
    void guardar(StudentDto t);
    void eliminar(Long id);
}
