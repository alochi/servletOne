package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.servlets.db.ConnectionManager.ConnectionManagerImpl;
import ru.innopolis.stc9.servlets.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAOImpl implements UsersDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public Users getUserByLogin(String login) throws SQLException {
        Users result = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * " +
                "FROM users " +
                "WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = new Users(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("passwordHash"), resultSet.getInt("role"));
        }
        connection.close();
        return result;
    }
}
