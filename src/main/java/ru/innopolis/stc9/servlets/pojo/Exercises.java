package ru.innopolis.stc9.servlets.pojo;

/**
 * Created by admin on 25.04.2018.
 */
public class Exercises {
    private int id;
    private int subjects_id;
    private String date;
    private String exercise;

    public Exercises(int id, int subjects_id, String date, String exercise) {
        this.id = id;
        this.subjects_id = subjects_id;
        this.date = date;
        this.exercise = exercise;
    }

    public Exercises(int subjects_id, String date, String exercise) {
        this.subjects_id = subjects_id;
        this.date = date;
        this.exercise = exercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjects_id() {
        return subjects_id;
    }

    public void setSubjects_id(int subjects_id) {
        this.subjects_id = subjects_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
}
