package com.example.repository.impl;

import com.example.domain.enums.Career;
import com.example.domain.exceptions.UniversityException;
import com.example.domain.models.Student;
import com.example.mapping.dtos.StudentDto;
import com.example.mapping.mapper.StudentMapper;
import com.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryLogicImpl implements Repository<StudentDto> {
    private List<Student> students;

    public StudentRepositoryLogicImpl() {
        Student s1 = new Student(1L,"Monica","mtobon@cue","sexto semestre", "Career.SOFTWARE");
        Student s2 = new Student(2L,"Pepe","pepe22@cue","cuarto semestre" ,"Career.SOFTWARE");
        Student s3 = new Student(3L,"Juan","juan11@cue","tercer semestre", "Career.INDUSTRIAL");
        students = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<StudentDto> list() {
        return StudentMapper.mapFrom(students);
    }

    @Override
    public StudentDto byId(Long id) {
        return students.stream()
                .filter(e->e.getId_Students() == (e.getId_Students()))
                .findFirst()
                .map(StudentMapper::mapFrom)
                .orElseThrow(()-> new UniversityException("Student not found"));
    }

    @Override
    public void update(StudentDto student) {
        StudentMapper.mapFrom(students);

    }

    @Override
    public void delete(Long id) {
        StudentMapper.mapFrom(students);

    }

}