package com.example.mapping.mapper;

import com.example.domain.models.Teacher;
import com.example.mapping.dtos.TeacherDto;

import java.util.List;

public class TeacherMapper {
    public static TeacherDto mapFrom(Teacher source){
        return new TeacherDto(source.getId_Teachers(),
                source.getName(),
                source.getEmail());
    }
    public static Teacher mapFrom(TeacherDto source){
        return new Teacher(source.id_Teachers(),
                source.name(),
                source.email());
    }
    public static List<TeacherDto> mapFrom(List<Teacher>sources){
        return sources.parallelStream().map(e->mapFrom(e)).toList();
    }
}
