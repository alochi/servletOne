package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.pojo.Exercises;

import java.util.ArrayList;

public interface ExercisesService {
    ArrayList<Exercises> getExercises();
    ArrayList<Exercises> getExercises(String date);
    void addExercise(Exercises exercise);
}