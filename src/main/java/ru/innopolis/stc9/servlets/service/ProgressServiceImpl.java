package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.ProgressDAO;
import ru.innopolis.stc9.servlets.db.dao.ProgressDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgressServiceImpl implements ProgressService {
    private ProgressDAO progressDAO = new ProgressDAOImpl();

    @Override
    public ArrayList<Progress> getProgressByMark(int greaterOrEqualMark, int lessOrEqualMark, String login) {
        try {
            return progressDAO.getProgress(greaterOrEqualMark, lessOrEqualMark, login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMark(String student_id, String edate, String mark, String attendance) {
        try {
            progressDAO.addMark(student_id, edate, mark, attendance);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
