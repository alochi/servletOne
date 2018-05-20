package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.SubjectsDAO;
import ru.innopolis.stc9.servlets.db.dao.SubjectsDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Subjects;

import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectsServiceImpl implements SubjectsService{
    private SubjectsDAO subjectsDAO = new SubjectsDAOImpl();

    @Override
    public ArrayList<Subjects> getSubjects() {
        try {
            return subjectsDAO.getSubjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
