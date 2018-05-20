package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 24.04.2018.
 */
public class StudentsDAOImpl implements StudentsDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public void addStudent(String nameStud, String loginStud, String passwordhashStud) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO students(name, login, passwordhash) " +
                "VALUES (?, ?, ?)");
        statement.setString(1, nameStud);
        statement.setString(2, loginStud);
        statement.setString(3, passwordhashStud);
        statement.execute();
        connection.close();
    }

    @Override
    public ArrayList<Students> getStudents() throws SQLException {
        ArrayList<Students> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM students WHERE role=2");
        ResultSet resultSet = statement.executeQuery();
        Students student = null;
        while (resultSet.next()) {
            student = new Students(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("login"),
                    resultSet.getString("passwordhash"));
            result.add(student);
        }
        connection.close();
        return result;
    }

    @Override
    public void updateStudent(Students student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE students " +
                "SET name = ?, login = ?, passwordhash = ? WHERE id = ?");
        statement.setString(1, student.getName());
        statement.setString(2, student.getLogin());
        statement.setString(3, student.getPasswordhash());
        statement.setInt(4, student.getId());
        statement.execute();
        connection.close();
    }
}
