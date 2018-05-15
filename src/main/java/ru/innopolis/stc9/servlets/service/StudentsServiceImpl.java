package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.StudentsDAO;
import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.SQLException;
import java.util.ArrayList;


public class StudentsServiceImpl implements StudentsService {
    private StudentsDAO studentsDAO = new StudentsDAOImpl();

    @Override
    public ArrayList<Students> getStudentsById() {
        try {
            return studentsDAO.getStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
