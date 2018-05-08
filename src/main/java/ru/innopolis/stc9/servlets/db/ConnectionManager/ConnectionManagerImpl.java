package ru.innopolis.stc9.servlets.db.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 24.04.2018.
 */
public class ConnectionManagerImpl implements ConnectionManager{
    private static ConnectionManager connectionManager;

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerImpl();
        }
        return connectionManager;
    }

    private ConnectionManagerImpl() {
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/StudentProgress",
                    "postgres",
                    "1727");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
