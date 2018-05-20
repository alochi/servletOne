package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.ExercisesDAO;
import ru.innopolis.stc9.servlets.db.dao.ExercisesDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExercisesServiceImpl implements ExercisesService {
    private ExercisesDAO exercisesDAO = new ExercisesDAOImpl();

    @Override
    public ArrayList<Exercises> getExercises() {
        try {
            return exercisesDAO.getExercises();
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
