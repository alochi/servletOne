package ru.innopolis.stc9.servlets.pojo;

/**
 * Created by admin on 24.04.2018.
 */
public class Students implements Comparable<Students> {
    private int id;
    private String name;
    private String login;
    private String passwordhash;

    public Students(int id, String name, String login, String passwordhash) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.passwordhash = passwordhash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    @Override
    public int compareTo(Students s) {
        return this.getId() - s.getId();
    }
}
