package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.util.ArrayList;

public interface ExercisesService {
    ArrayList<Exercises> getExercises();
    void addExercise(Exercises exercise);
}