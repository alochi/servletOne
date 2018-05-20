package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Subjects;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectsDAO {
    ArrayList<Subjects> getSubjects() throws SQLException;
}
