package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
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
    final static Logger LOGGER = Logger.getLogger(ProgressDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public ArrayList<Progress> getProgress(int greaterOrEqualMark, int lessOrEqualMark) throws SQLException {
        ArrayList<Progress> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        LOGGER.info(connection);
        PreparedStatement statement = connection.prepareStatement("SELECT " +
                "progress.id, mark, attendance, s2.name stud, e3.exercise exer, date, s4.subject " +
                "FROM progress " +
                "INNER JOIN students s2 ON progress.students_id = s2.id " +
                "INNER JOIN exercises e3 ON progress.exercises_id = e3.id " +
                "INNER JOIN subjects s4 ON e3.subjects_id = s4.id " +
                "WHERE mark >= ? AND mark <= ?");
        statement.setInt(1, greaterOrEqualMark);
        statement.setInt(2, lessOrEqualMark);
        ResultSet resultSet = statement.executeQuery();
        Progress progress = null;
        while (resultSet.next()) {
            progress = new Progress(
                    resultSet.getInt("id"),
                    resultSet.getString("stud"),
                    resultSet.getString("exer"),
                    resultSet.getInt("mark"),
                    resultSet.getBoolean("attendance"),
                    resultSet.getDate("date"),
                    resultSet.getString("subject"));
            result.add(progress);
        }
        connection.close();
        LOGGER.info(connection);
        return result;
    }

}
