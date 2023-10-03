package com.example.repository.impl;

import com.example.domain.exceptions.ServiceJdbcException;
import com.example.domain.models.Student;
import com.example.mapping.dtos.StudentDto;
import com.example.mapping.mapper.StudentMapper;
import com.example.repository.Repository;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

public class StudentRepositoryImpl implements Repository<StudentDto> {
    private Connection conn;
    public StudentRepositoryImpl(Connection conn) {
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
    public List<StudentDto> list(){
        List<Student> studentList = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * from students")) {
            while (rs.next()) {
                Student ps= createStudent(rs);
                studentList.add(ps);
            }
        } catch (SQLException e) {
            throw new ServiceJdbcException("Unable to list info");
        }
        return StudentMapper.mapFrom(studentList);
    }


    @Override
    public StudentDto byId(Long id) {
        Student student = null;
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE id_student=?")) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    student = createStudent(rs);
                }
            }
        } catch (SQLException e) {
            throw new ServiceJdbcException("Unable to find info");
        }
        return StudentMapper.mapFrom(student);
    }

    @Override
    public void update(StudentDto student) {
        String sql;
        if (student.id_Students() != null && student.id_Students() > 0) {
            sql = "UPDATE student SET name=?, email=?, semester=?, career=? WHERE id_student=?";
        } else {
            sql = "INSERT INTO student (name, email, semester, career) VALUES(?,?,?,?)";
        }
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.name());
            pstmt.setString(2, student.email());
            pstmt.setString(3, student.semester());
            pstmt.setString(4, student.career());

            if (student.id_Students() != null && student.id_Students() > 0) {
                pstmt.setLong(5, student.id_Students());
            }
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException("Unable to save info");
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM student WHERE id_student = ?")) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new ServiceJdbcException("Unable to delete info");
        }
    }


}