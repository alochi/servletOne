package ru.innopolis.stc9.servlets.db.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by admin on 25.04.2018.
 */
public class ProgressDAOImpl implements ProgressDAO {
    final static Logger LOGGER = Logger.getLogger(ProgressDAOImpl.class);
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    /**
     * Если логин не равен админу, то показываем только для определенного пользователя, иначе показываем все
     * @param greaterOrEqualMark
     * @param lessOrEqualMark
     * @param login
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Progress> getProgress(int greaterOrEqualMark, int lessOrEqualMark, String login) throws SQLException {
        ArrayList<Progress> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT " +
                "progress.id, mark, attendance, s2.name stud, s2.login studlogin, e3.exercise exer, date, s4.subject " +
                "FROM progress " +
                "INNER JOIN students s2 ON progress.students_id = s2.id " +
                "INNER JOIN exercises e3 ON progress.exercises_id = e3.id " +
                "INNER JOIN subjects s4 ON e3.subjects_id = s4.id " +
                "WHERE mark >= ? AND mark <= ?" + sqlLogin(login));
        statement.setInt(1, greaterOrEqualMark);
        statement.setInt(2, lessOrEqualMark);
        if (isNotTeacher(login)) {
            statement.setString(3, login);
        }
        ResultSet resultSet = statement.executeQuery();
        Progress progress = null;
        while (resultSet.next()) {
            progress = new Progress(
                    resultSet.getInt("id"),
                    resultSet.getString("stud"),
                    resultSet.getString("studlogin"),
                    resultSet.getString("exer"),
                    resultSet.getInt("mark"),
                    resultSet.getBoolean("attendance"),
                    resultSet.getDate("date"),
                    resultSet.getString("subject"));
            result.add(progress);
        }
        connection.close();
        return result;
    }

    /**
     * Если не учитель то добавляем условие, чтобы каждый студент мог видеть только свои данные)
     * @param login
     * @return
     */
    private String sqlLogin(String login) {
        String sql = "";
        if (isNotTeacher(login)) {
            sql = " AND s2.login LIKE ?";
        }
        return sql;
    }

    //TODO Явно идет проверка на "teacher"
    private boolean isNotTeacher(String login) {
        return !login.equals("teacher");
    }

    @Override
    public void addMark(String student_id, String edate, String mark, String attendance) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO progress(students_id, exercises_id, mark, attendance) " +
                "VALUES (?, ?, ?, ?)");
        statement.setInt(1, Integer.parseInt(student_id));
        statement.setInt(2, Integer.parseInt(edate));
        statement.setInt(3, Integer.parseInt(mark));
        statement.setBoolean(4, Boolean.parseBoolean(attendance));
        statement.execute();
        connection.close();
    }
}
