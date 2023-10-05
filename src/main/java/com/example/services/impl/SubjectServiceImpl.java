package com.example.services.impl;

import com.example.mapping.dtos.SubjectDto;
import com.example.repository.Repository;
import com.example.services.SubjectService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import java.util.List;
@NoArgsConstructor

@ApplicationScoped
public class SubjectServiceImpl implements SubjectService {
    @Inject
    private Repository<SubjectDto> repo;
    @Override
    public List<SubjectDto> list() {
        return repo.list();
    }

    @Override
    public SubjectDto byId(Long id) {
        return repo.byId(id);
    }

    @Override
    public void update(SubjectDto subject) {
        repo.update(subject);
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}