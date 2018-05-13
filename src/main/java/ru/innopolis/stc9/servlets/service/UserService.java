package ru.innopolis.stc9.servlets.service;

public interface UserService {
    boolean checkAuth(String login, String password);
    Integer getRole(String login);
}
