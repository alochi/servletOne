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
    private final StudentsService studentsService = new StudentsServiceImpl();

    /**
     * Формируем таблицу студентов
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Students> students = studentsService.getStudents();
        req.setAttribute("students", students);
        req.setAttribute("role", req.getSession().getAttribute("role"));

        req.getRequestDispatcher("/reportStudents.jsp").forward(req, resp);
    }

    /**
     * На странице reportStudents.jsp у нас 2 формы (редактирование и добавление студента) поэтому 2 условия.
     * Собираем данные и кидаем в сервис
     * Для передачи данных из таблицы в клиентское "модальное" окно "Редактирование студента" используем JS,
     * перекидываем через id элементов (скрипт "../assets/js/setid.js"), класс m_editstud 41 строка reportStudents.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("editForm".equals(req.getParameter("form"))) {
            int editStudId = Integer.parseInt(req.getParameter("editStudId"));
            String editStudName = req.getParameter("editStudName");
            String editStudLogin = req.getParameter("editStudLogin");
            String editStudPasswordhash = req.getParameter("editStudPasswordhash");
            Students editStudent = new Students(editStudId, editStudName, editStudLogin, editStudPasswordhash);
            if (!editStudName.equals("") && !editStudLogin.equals("")) {
                studentsService.editStudent(editStudent);
            }
        } else if ("addForm".equals(req.getParameter("form"))) {
            String addStudName = req.getParameter("addStudName");
            String addStudLogin = req.getParameter("addStudLogin");
            String addStudPasswordhash = req.getParameter("addStudPasswordhash");
            if (!addStudName.equals("") && !addStudLogin.equals("")) {
                studentsService.addStudent(addStudName, addStudLogin, addStudPasswordhash);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/inner/students");
    }


}
