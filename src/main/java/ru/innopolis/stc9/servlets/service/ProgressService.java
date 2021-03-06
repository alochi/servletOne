package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.pojo.Progress;

import java.util.ArrayList;

public interface ProgressService {
    ArrayList<Progress> getProgressByMark(int greaterOrEqualMark, int lessOrEqualMark, String login);
    void addMark(String student_id, String edate, String mark, String attendance);
}
