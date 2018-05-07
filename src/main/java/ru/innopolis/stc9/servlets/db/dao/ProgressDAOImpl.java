package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 25.04.2018.
 */
public class ProgressDAOImpl implements ProgressDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public void addProgress(Progress progress) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO progress (id, students_id, exercises_id, mark, attendance) " +
                "VALUES (?, ?, ?, ?, ?)");
        statement.setInt(1, progress.getId());
        statement.setInt(2, progress.getStudents_id());
        statement.setInt(3, progress.getExercises_id());
        statement.setInt(4, progress.getMark());
        statement.setBoolean(5, progress.isAttendance());
        statement.execute();
        connection.close();
    }

    @Override
    public Progress getProgressById(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM progress WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Progress progress = null;
        if (resultSet.next()) {
            progress = new Progress(
                    resultSet.getInt("id"),
                    resultSet.getInt("students_id"),
                    resultSet.getInt("exercises_id"),
                    resultSet.getInt("mark"),
                    resultSet.getBoolean("attendance"));
        }
        connection.close();
        return progress;
    }

    @Override
    public void updateProgress(Progress progress) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE progress " +
                "SET students_id = ?, exercises_id = ?, mark = ?, attendance = ?  WHERE id = ?");
        statement.setInt(1, progress.getStudents_id());
        statement.setInt(2, progress.getExercises_id());
        statement.setInt(3, progress.getMark());
        statement.setBoolean(4, progress.isAttendance());
        statement.setInt(5, progress.getId());
        statement.execute();
        connection.close();
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
