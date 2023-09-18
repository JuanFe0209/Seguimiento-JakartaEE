package com.example.repository.impl;

import com.example.domain.exceptions.UniversityException;
import com.example.domain.models.Subject;
import com.example.domain.models.Teacher;
import com.example.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryLogicImpl implements Repository<Subject> {
    private List<Subject> subjects;

    public SubjectRepositoryLogicImpl() {
        Subject s1 = new Subject(1L,"Calculus",Teacher.builder().build());
        Subject s2 = new Subject(2L,"Statistic",Teacher.builder().build());
        Subject s3 = new Subject(3L,"Data Bases",Teacher.builder().build());
        subjects = new ArrayList<Subject>(List.of(s1, s2, s3));
    }

    @Override
    public List<Subject> list() {
        return subjects;
    }

    @Override
    public Subject byId(Long id) {
        return subjects.stream()
                .filter(e -> id.equals(e.getId_Subjects()))
                .findFirst()
                .orElseThrow(() -> new UniversityException("Subject not found"));
    }

    @Override
    public void update(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void delete(Long id) {
        subjects.removeIf(e->e.getId_Subjects().equals(id));
    }
}