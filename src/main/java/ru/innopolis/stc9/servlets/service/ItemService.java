package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.StudentsDAO;
import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.SQLException;

public class ItemService {
    private StudentsDAO studentsDAO = new StudentsDAOImpl();

    public Students getStudentById(int id) {
        try {
            return studentsDAO.getStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
