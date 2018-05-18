package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.StudentsService;
import ru.innopolis.stc9.servlets.service.StudentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class StudentsController extends HttpServlet {
    private StudentsService studentsService = new StudentsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Students> students = studentsService.getStudents();
        req.setAttribute("students", students);
        req.setAttribute("role", req.getSession().getAttribute("role"));

        req.getRequestDispatcher("/reportStudents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
