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
public class Teacher implements Serializable {
    private Long id_Teachers;
    private String name;
    private String email;

}
