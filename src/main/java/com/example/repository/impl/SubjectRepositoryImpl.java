package com.example.repository.impl;


import com.example.annotations.MysqlConn;
import com.example.conexion.ConexionBD;
import com.example.domain.models.Subject;
import com.example.domain.models.Teacher;
import com.example.mapping.dtos.SubjectDto;
import com.example.mapping.mapper.SubjectMapper;
import com.example.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class SubjectRepositoryImpl implements Repository<SubjectDto> {
    @Inject
    @MysqlConn
    private Connection getConnection() throws SQLException {
        return ConexionBD.getInstance();
    }

    private Subject buildObject(ResultSet resultSet) throws
            SQLException {
        Subject subject = new Subject();
        subject.setId_Subjects(resultSet.getLong("id_subject"));
        subject.setName(resultSet.getString("name"));
        Teacher teacher = new Teacher();
        teacher.setId_Teachers(resultSet.getLong("id_teacher"));
        teacher.setName(resultSet.getString("name"));
        teacher.setEmail(resultSet.getString("email"));
        subject.setTeacher(teacher);

        return subject;
    }

    @Override
    public List<SubjectDto> list() {
        List<Subject> SubjectList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT subject.name, teachers.name, teachers.email " +
                     "FROM subject INNER JOIN teachers on subject.id_teacher=teachers.id_teacher;")) {
            while (resultSet.next()) {
                Subject Subject = buildObject(resultSet);
                SubjectList.add(Subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SubjectMapper.mapFrom(SubjectList);
    }

    @Override
    public SubjectDto byId(Long id) {
        Subject subject = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT subject.name, teachers.name, teachers.email FROM subject INNER JOIN " +
                        "teachers on subject.id_teacher=teachers.id_teacher WHERE subject.id_subject = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                subject = buildObject(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SubjectMapper.mapFrom(subject);
    }
    @Override
    public void update(SubjectDto Subject) {
        String sql;
        if (Subject.subjectId() != null && Subject.subjectId() > 0) {
            sql = "UPDATE subjects SET name=?, id_teacher=? WHERE id_subject=?";
        } else {
            sql = "INSERT INTO subjects (name, id_teacher) VALUES(?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, Subject.subjectName());
            stmt.setLong(2, Subject.teacher().getId_Teachers());

            if (Subject.subjectId() != null && Subject.subjectId() > 0) {
                stmt.setLong(3, Subject.subjectId());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM subjects WHERE id_subject =?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}