package ru.innopolis.stc9.servlets.db.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDAO<T> {
/*
    void addExercise(Exercises exercise) throws SQLException;
    void addStudent(String nameStud, String loginStud, String passwordhashStud) throws SQLException;
    void addMark(String student_id, String edate, String mark, String attendance) throws SQLException;

    ArrayList<Exercises> getExercises() throws SQLException;
    ArrayList<Progress> getProgress(int greaterOrEqualMark, int lessOrEqualMark, String login) throws SQLException;
    ArrayList<Students> getStudents() throws SQLException;
    ArrayList<Subjects> getSubjects() throws SQLException;

    void updateStudent(Students student) throws SQLException;
    Users getUserByLogin(String login) throws SQLException;
*/

    public void add() throws SQLException;

    public ArrayList<T> getAll() throws SQLException;

}
