package ru.innopolis.stc9.servlets.db.ConnectionManager;

import java.sql.Connection;

/**
 * Created by admin on 24.04.2018.
 */
public interface ConnectionManager {
    public Connection getConnection();
}
