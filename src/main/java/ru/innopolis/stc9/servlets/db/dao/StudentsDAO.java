package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 24.04.2018.
 */
public interface StudentsDAO {
    void addStudent(Students student) throws SQLException;
    ArrayList<Students> getStudents() throws SQLException;
    void updateStudent(Students student) throws SQLException;
}
