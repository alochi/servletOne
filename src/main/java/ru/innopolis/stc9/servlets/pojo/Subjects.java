package ru.innopolis.stc9.servlets.pojo;

/**
 * Created by admin on 25.04.2018.
 */
public class Subjects {
    private int id;
    private String subject;

    public Subjects(int id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
