package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.sql.*;
import java.util.ArrayList;

public class ExercisesDAOImpl implements ExercisesDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public void addExercise(Exercises exercise) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO exercises(subjects_id, date, exercise) " +
                "VALUES (?, ?, ?)");
        statement.setInt(1, exercise.getSubjects_id());
        statement.setString(2, exercise.getDate());
        statement.setString(3, exercise.getExercise());
        statement.execute();
        connection.close();
    }

    @Override
    public ArrayList<Exercises> getExercises() throws SQLException {
        ArrayList<Exercises> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM exercises");
        ResultSet resultSet = statement.executeQuery();
        Exercises exercise = null;
        while (resultSet.next()) {
            exercise = new Exercises(
                    resultSet.getInt("id"),
                    resultSet.getInt("subjects_id"),
                    resultSet.getString("date"),
                    resultSet.getString("exercise"));
            result.add(exercise);
        }
        connection.close();
        return result;
    }

    @Override
    public ArrayList<Exercises> getExercises(String date) throws SQLException {
        ArrayList<Exercises> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM exercises WHERE date LIKE ?");
        statement.setString(1, date);
        ResultSet resultSet = statement.executeQuery();
        Exercises exercise = null;
        while (resultSet.next()) {
            exercise = new Exercises(
                    resultSet.getInt("id"),
                    resultSet.getInt("subjects_id"),
                    resultSet.getString("date"),
                    resultSet.getString("exercise"));
            result.add(exercise);
        }
        connection.close();
        return result;
    }
}
