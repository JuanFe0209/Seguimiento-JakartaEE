package com.example.mapping.dtos;
import com.example.domain.models.Student;
import com.example.domain.models.Subject;
import lombok.Builder;
@Builder

public record GradeDto(
        Long gradesId,
        Student student,
        Subject subject,
        Double grade,
        String corte) {

    public GradeDto(Long gradesId, Double grade, String corte) {
        this(gradesId, null, null, grade, corte);
    }
}