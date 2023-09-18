package com.example.repository.impl;

import com.example.domain.enums.Career;
import com.example.domain.exceptions.UniversityException;
import com.example.domain.models.Student;
import com.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryLogicImpl implements Repository<Student> {
    private List<Student> students;

    public StudentRepositoryLogicImpl() {
        Student s1 = new Student(1L,"Monica","mtobon@cue","sexto semestre", Career.SOFTWARE);
        Student s2 = new Student(2L,"Pepe","pepe22@cue","cuarto semestre" ,Career.SOFTWARE);
        Student s3 = new Student(3L,"Juan","juan11@cue","tercer semestre", Career.INDUSTRIAL);
        students = new ArrayList<>(List.of(s1, s2, s3));
    }

    @Override
    public List<Student> list() {
        return students;
    }

    @Override
    public Student byId(Long id) {
        return students.stream()
                .filter(e -> id.equals(e.getId_Students()))
                .findFirst()
                .orElseThrow(() -> new UniversityException("Student not found"));
    }


    @Override
    public void update(Student student) {
        students.add(student);
    }

    @Override
    public void delete(Long id) {
        students.removeIf(e->e.getId_Students().equals(id));
    }
}