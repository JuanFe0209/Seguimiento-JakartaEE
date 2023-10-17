package com.example.mapping.dtos;
import com.example.domain.models.Teacher;
import lombok.Builder;

@Builder
public record SubjectDto (
        Long subjectId,
        String subjectName,
        Teacher teacher){

    public SubjectDto(Long subjectId, String subjectName) {
        this(subjectId, subjectName, null);
    }
}