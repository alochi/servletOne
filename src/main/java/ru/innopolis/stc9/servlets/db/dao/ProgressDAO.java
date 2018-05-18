package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 25.04.2018.
 */
public interface ProgressDAO {
    ArrayList<Progress> getProgress(int greaterOrEqualMark, int lessOrEqualMark) throws SQLException;
    void deleteProgressById(int id) throws SQLException;
}
