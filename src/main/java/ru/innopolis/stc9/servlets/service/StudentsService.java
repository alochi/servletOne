package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.pojo.Students;

import java.util.ArrayList;

public interface StudentsService {
    ArrayList<Students> getStudents();
    void editStudent(Students student);
}
