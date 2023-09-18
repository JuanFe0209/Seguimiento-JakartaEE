package com.example.mapping.dtos;
import com.example.domain.models.Student;
import com.example.domain.models.Subject;

public record GradeDto(Long id_Grades,
                       Student student,
                       Subject subject,
                       String corte){
}
