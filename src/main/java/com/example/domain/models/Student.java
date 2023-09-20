package com.example.domain.models;
import com.example.domain.enums.Career;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {
    private Long id_Students;
    private String name;
    private String email;
    private String semester;
    private String career;

}

