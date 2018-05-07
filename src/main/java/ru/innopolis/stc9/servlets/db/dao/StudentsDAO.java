package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.SQLException;

/**
 * Created by admin on 24.04.2018.
 */
public interface StudentsDAO {
    void addStudent(Students student) throws SQLException;
    Students getStudentById(int id) throws SQLException;
    void updateStudent(Students student) throws SQLException;
    void deleteStudentById(int id) throws SQLException;
}
