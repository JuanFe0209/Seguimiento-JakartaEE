package com.example.domain.models;
import jakarta.enterprise.context.SessionScoped;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SessionScoped
public class Subject implements Serializable {
    private Long id_Subjects;
    private String name;
    private Teacher teacher;

}