package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 25.04.2018.
 */
public class ProgressDAOImpl implements ProgressDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public ArrayList<Progress> getMark(int mark) throws SQLException {
        ArrayList<Progress> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT " +
                "progress.id, mark, attendance, s2.name stud, e3.exercise exer, date " +
                "FROM progress " +
                "INNER JOIN students s2 ON progress.students_id = s2.id " +
                "INNER JOIN exercises e3 ON progress.exercises_id = e3.id " +
                "WHERE mark = ?");
        statement.setInt(1, mark);
        ResultSet resultSet = statement.executeQuery();
        Progress progress = null;
        while (resultSet.next()) {
            progress = new Progress(
                    resultSet.getInt("id"),
                    resultSet.getString("stud"),
                    resultSet.getString("exer"),
                    resultSet.getInt("mark"),
                    resultSet.getBoolean("attendance"),
                    resultSet.getDate("date"));
            result.add(progress);
        }
        connection.close();
        return result;
    }

    @Override
    public void deleteProgressById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM progress " +
                "WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }
}
