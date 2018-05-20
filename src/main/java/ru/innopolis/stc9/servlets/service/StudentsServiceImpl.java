package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.StudentsDAO;
import ru.innopolis.stc9.servlets.db.dao.StudentsDAOImpl;
import ru.innopolis.stc9.servlets.pojo.Students;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class StudentsServiceImpl implements StudentsService {
    private StudentsDAO studentsDAO = new StudentsDAOImpl();

    /**
     * Возвращаем список студентов
     * @return
     */
    @Override
    public ArrayList<Students> getStudents() {
        try {
            ArrayList<Students> tempList = new ArrayList<>(studentsDAO.getStudents());
            Collections.sort(tempList);
            return tempList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Редактируем студента
     * @param student
     */
    @Override
    public void editStudent(Students student) {
        try {
            if (student != null) {
                studentsDAO.updateStudent(student);
            } else {
                throw new NullPointerException("Parameter student cannot be null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(String nameStud, String loginStud, String passwordhashStud) {
        try {
            studentsDAO.addStudent(nameStud, loginStud, passwordhashStud);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
