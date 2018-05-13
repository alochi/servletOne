package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.ProgressDAO;
import ru.innopolis.stc9.servlets.db.dao.ProgressDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemServiceImpl implements ItemService {
    private ProgressDAO progressDAO = new ProgressDAOImpl();

    @Override
    public ArrayList<Progress> getStudentById(int mark) {
        try {
            return progressDAO.getMark(mark);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
