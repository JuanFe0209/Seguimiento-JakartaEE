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
public class Student implements Serializable {
    private Long id_Students;
    private String name;
    private String email;
    private String semester;
    private String career;

}

