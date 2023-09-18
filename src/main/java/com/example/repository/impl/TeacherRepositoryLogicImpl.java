package com.example.repository.impl;

import com.example.domain.exceptions.UniversityException;
import com.example.domain.models.Subject;
import com.example.domain.models.Teacher;
import com.example.repository.Repository;

import java.util.List;

public class TeacherRepositoryLogicImpl implements Repository<Teacher> {
    private List<Teacher> teachers;

    public TeacherRepositoryLogicImpl(){
        Teacher s1 = new Teacher(1L, "Arle","Arle22@cue");
        Teacher s2 = new Teacher(2L, "Monica","monica@cue");
        Teacher s3 = new Teacher(3L, "Julian","julian1@cue");
    }
    @Override
    public List<Teacher> list() {
        return teachers;
    }

    @Override
    public Teacher byId(Long id) {
        return teachers.stream()
                .filter(e -> id.equals(e.getId_Teachers()))
                .findFirst()
                .orElseThrow(() -> new UniversityException("Subject not found"));
    }
    @Override
    public void update(Teacher teacher) {
        teachers.add(teacher);
    }
    @Override
    public void delete(Long id) {
        teachers.removeIf(e->e.getId_Teachers().equals(id));
    }
}