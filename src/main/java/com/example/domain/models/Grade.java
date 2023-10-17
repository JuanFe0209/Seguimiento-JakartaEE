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
public class Grade implements Serializable {
    private Long id_Grades;
    private Student student;
    private Subject subject;
    private Double grade;
    private String corte;

}