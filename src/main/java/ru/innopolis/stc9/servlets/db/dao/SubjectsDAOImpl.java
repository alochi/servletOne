package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Subjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO нужен только для вывода списка при добавлении нового занятия
 */
public class SubjectsDAOImpl implements SubjectsDAO{
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public ArrayList<Subjects> getSubjects() throws SQLException {
        ArrayList<Subjects> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM subjects");
        ResultSet resultSet = statement.executeQuery();
        Subjects subjects = null;
        while (resultSet.next()) {
            subjects = new Subjects(
                    resultSet.getInt("id"),
                    resultSet.getString("subject"));
            result.add(subjects);
        }
        connection.close();
        return result;
    }
}
