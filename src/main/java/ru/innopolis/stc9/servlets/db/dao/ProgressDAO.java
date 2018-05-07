package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Progress;

import java.sql.SQLException;

/**
 * Created by admin on 25.04.2018.
 */
public interface ProgressDAO {
    void addProgress(Progress progress) throws SQLException;
    Progress getProgressById(int id) throws SQLException;
    void updateProgress(Progress progress) throws SQLException;
    void deleteProgressById(int id) throws SQLException;
}
