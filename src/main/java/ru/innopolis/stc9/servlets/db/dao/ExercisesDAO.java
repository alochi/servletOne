package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExercisesDAO {
    void addExercise(Exercises exercise) throws SQLException;
    ArrayList<Exercises> getExercises() throws SQLException;
}
