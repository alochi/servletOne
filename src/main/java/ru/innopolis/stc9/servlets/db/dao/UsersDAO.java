package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Users;

import java.sql.SQLException;

public interface UsersDAO {
    Users getUserByLogin(String login) throws SQLException;
}
