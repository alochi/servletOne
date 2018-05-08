package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 24.04.2018.
 */
public class StudentsDAOImpl implements StudentsDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public void addStudent(Students student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO students(id, name) " +
                "VALUES (?, ?)");
        statement.setInt(1, student.getId());
        statement.setString(2, student.getName());
        statement.execute();
        connection.close();
    }

    @Override
    public Students getStudentById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM students WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Students student = null;
        if (resultSet.next()) {
            student = new Students(
                    resultSet.getInt("id"),
                    resultSet.getString("name"));
        }
        connection.close();
        return student;
    }

    @Override
    public void updateStudent(Students student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE students " +
                "SET name = ? WHERE id = ?");
        statement.setString(1, student.getName());
        statement.setInt(2, student.getId());
        statement.execute();
        connection.close();
    }

    @Override
    public void deleteStudentById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM students " +
                "WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }
}
