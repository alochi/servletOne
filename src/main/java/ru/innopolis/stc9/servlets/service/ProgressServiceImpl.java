package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.ProgressDAO;
import ru.innopolis.stc9.servlets.db.dao.ProgressDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgressServiceImpl implements ProgressService {
    private ProgressDAO progressDAO = new ProgressDAOImpl();

    @Override
    public ArrayList<Progress> getProgressByMark(int greaterOrEqualMark, int lessOrEqualMark) {
        try {
            return progressDAO.getProgress(greaterOrEqualMark, lessOrEqualMark);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
