package com.example.services;

import com.example.mapping.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> list();
    TeacherDto byId(Long id);
    void update(TeacherDto t);
    void delete(Long id);

}