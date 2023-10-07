package com.example.controllers;

import com.example.mapping.dtos.StudentDto;
import com.example.repository.impl.StudentRepositoryLogicImpl;
import com.example.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet(name= "studentId", value="/student-formId")
public class StudentId extends HttpServlet {
    @Inject
    private StudentService service;


    protected void doPost(HttpServlet request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id_student = null;
        String studentIdStr = request.getInitParameter("id");

        if (studentIdStr != null && !studentIdStr.isEmpty()) {
            try {
                id_student = Long.parseLong(studentIdStr);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de estudiante no válido");
                return;
            }
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h1>Por favor, ingrese un ID de estudiante.</h1>");
            return;
        }

        Optional<StudentDto> studentOptional = Optional.ofNullable(service.byId(id_student));

        if (studentOptional.isPresent()) {
            StudentDto student = studentOptional.get();
            response.setContentType("text/html");
            response.getWriter().println("<h1>Estudiante Encontrado:</h1>");
            response.getWriter().println("<p>ID: " + student.id_Students() + "</p>");
            response.getWriter().println("<p>Nombre: " + student.name() + "</p>");
            response.getWriter().println("<p>Correo: " + student.email() + "</p>");
            response.getWriter().println("<p>Semestre: " + student.semester() + "</p>");
            response.getWriter().println("<p>Carrera: " + student.career() + "</p>");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Estudiante no encontrado");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        Connection conn = (Connection) req.getAttribute("conn");
        ServletInputStream JsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        StudentDto studentDto = mapper.readValue(JsonStream,
                StudentDto.class);
        Long id = studentDto.id_Students();
        service.byId(id);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Students</h1>");
        out.println(service.byId(id));
        out.println("</body></html>");
    }
}
