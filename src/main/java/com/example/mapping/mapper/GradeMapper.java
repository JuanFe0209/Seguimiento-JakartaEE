package com.example.mapping.mapper;
import com.example.domain.models.Grade;
import com.example.mapping.dtos.GradeDto;

import java.util.List;

public class GradeMapper {
    public static GradeDto mapFrom(Grade source) {
        return new GradeDto(source.getId_Grades(),
                source.getStudent(),
                source.getSubject(),
                source.getGrade(),
                source.getCorte());
    }

    public static Grade mapFrom(GradeDto source){
        return new Grade(source.gradesId(),
                source.student(),
                source.subject(),
                source.grade(),
                source.corte());
    }

    public static List<GradeDto> mapFrom(List<Grade> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}