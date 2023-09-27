package com.example.repository.impl;

import com.example.conexion.ConexionBD;
import com.example.domain.enums.Career;
import com.example.domain.models.Student;
import com.example.mapping.dtos.StudentDto;
import com.example.mapping.mapper.StudentMapper;
import com.example.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.utils.ConexionBaseDatos.getConnection;

public class StudentRepositoryJdbcImpl implements Repository<StudentDto> {

    private Connection conn;
    public StudentRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    private Student createStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId_Students(rs.getLong("id_student"));
        student.setName(rs.getString("nombre"));
        student.setEmail(rs.getString("email"));
        student.setCareer(rs.getString("career"));
        student.setSemester(rs.getString("semester"));
        return student;
    }
    @Override
    public List<StudentDto> list() {
        List<Student> students = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT s.* order by s.id ASC")) {
            while (rs.next()) {
                Student ps= createStudent(rs);
                students.add(ps);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return StudentMapper.mapFrom(students);
    }
    @Override
    public StudentDto byId(Long id) {
        Student student = null;
        try (PreparedStatement preparedStatement = conn
                .prepareStatement("SELECT * FROM student WHERE id_student=?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = createStudent(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return StudentMapper.mapFrom(student);
    }

    @Override
    public void update(StudentDto student) {
        String sql;
        if (student.id_Students() != null && student.id_Students()>0) {
            sql = "UPDATE student SET name=?, career=?, email=?, semester=? WHERE id_student=?";
        } else {
            sql = "INSERT INTO student (name, career, email, semester) VALUES(?,?,?,?)";
        }
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.name());
            stmt.setString(2, String.valueOf(student.career()));

            if (student.id_Students() != null && student.id_Students() > 0) {
                stmt.setString(3, student.email());
                stmt.setLong(4, student.id_Students());
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = conn.prepareStatement("DELETE FROM student WHERE id_student =?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}