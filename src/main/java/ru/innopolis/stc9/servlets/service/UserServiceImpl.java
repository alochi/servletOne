package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.UsersDAO;
import ru.innopolis.stc9.servlets.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Users;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    public boolean checkAuth(String login, String password) {
        Users user = null;
        try {
            user = usersDAO.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (user != null) && (user.getPasswordHash().equals(password));
    }

    @Override
    public Integer getRole(String login) {
        //TODO: Рефакторинг, копипаста кода
        Users user = null;
        try {
            user = usersDAO.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null)
            return 0;
        return user.getRole();
    }
}
