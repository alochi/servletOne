package ru.innopolis.stc9.servlets.pojo;

import java.util.Date;

/**
 * Created by admin on 25.04.2018.
 */
public class Progress {
    private int id;
    private String students_name;
    private String exercises_name;
    private int mark;
    private boolean attendance;
    private Date date;

    public Progress(int id, String students_name, String exercises_name, int mark, boolean attendance, Date date) {
        this.id = id;
        this.students_name = students_name;
        this.exercises_name = exercises_name;
        this.mark = mark;
        this.attendance = attendance;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudents_name() {
        return students_name;
    }

    public void setStudents_name(String students_name) {
        this.students_name = students_name;
    }

    public String getExercises_name() {
        return exercises_name;
    }

    public void setExercises_name(String exercises_name) {
        this.exercises_name = exercises_name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
