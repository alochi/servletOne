package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.UsersDAO;
import ru.innopolis.stc9.servlets.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Users;

import java.sql.SQLException;

public class UserService {
    private static UsersDAO usersDAO = new UsersDAOImpl();

    public boolean checkAuth(String login, String password) {
        Users user = null;
        try {
            user = usersDAO.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (user != null) && (user.getPasswordHash().equals(password));
    }
}
