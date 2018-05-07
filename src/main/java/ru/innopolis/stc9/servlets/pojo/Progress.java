package ru.innopolis.stc9.servlets.pojo;

/**
 * Created by admin on 25.04.2018.
 */
public class Progress {
    private int id;
    private int students_id;
    private int exercises_id;
    private int mark;
    private boolean attendance;

    public Progress(int id, int students_id, int exercises_id, int mark, boolean attendance) {
        this.id = id;
        this.students_id = students_id;
        this.exercises_id = exercises_id;
        this.mark = mark;
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public int getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(int exercises_id) {
        this.exercises_id = exercises_id;
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
}
