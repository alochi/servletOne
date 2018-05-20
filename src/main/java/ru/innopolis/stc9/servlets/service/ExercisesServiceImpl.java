package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.ExercisesDAO;
import ru.innopolis.stc9.servlets.db.dao.ExercisesDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ExercisesServiceImpl implements ExercisesService {
    private ExercisesDAO exercisesDAO = new ExercisesDAOImpl();

    @Override
    public ArrayList<Exercises> getExercises() {
        try {
            ArrayList<Exercises> tempList = exercisesDAO.getExercises();
            Collections.sort(tempList);
            return tempList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Exercises> getExercises(String date) {
        try {
            return exercisesDAO.getExercises(date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addExercise(Exercises exercise) {
        try {
            exercisesDAO.addExercise(exercise);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
