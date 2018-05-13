package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.pojo.Progress;

import java.util.ArrayList;

public interface ItemService {
    ArrayList<Progress> getStudentById(int mark);
}
