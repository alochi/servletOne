package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 25.04.2018.
 */
public interface ProgressDAO {
    ArrayList<Progress> getProgress(int greaterOrEqualMark, int lessOrEqualMark, String login) throws SQLException;
    void addMark(String student_id, String edate, String mark, String attendance) throws SQLException;
}
