package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.pojo.Exercises;
import ru.innopolis.stc9.servlets.pojo.Progress;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgressController  extends HttpServlet {
    private ProgressService progressService = new ProgressServiceImpl();
    private StudentsService studentsService = new StudentsServiceImpl();
    private ExercisesService exercisesService = new ExercisesServiceImpl();

    /**
     * Формируем таблицу всех оценок от 0 до 5, где 0 - это нет оценок
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getSession().getAttribute("login");
        ArrayList<Progress> progress = progressService.getProgressByMark(0, 5, login);
        initData(req);
        req.setAttribute("role", req.getSession().getAttribute("role"));
        req.setAttribute("progress", progress);
        req.getRequestDispatcher("/reportProgress.jsp").forward(req, resp);
    }

    private void initData(HttpServletRequest req) {
        ArrayList<Students> students = studentsService.getStudents();
        ArrayList<Exercises> exercises = exercisesService.getExercises();
        req.setAttribute("students", students);
        req.setAttribute("exercises", exercises);
    }

    /**
     * Получаем параметр вида "0-5", формируем таблицу
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("filterForm".equals(req.getParameter("form"))) {
            String login = (String) req.getSession().getAttribute("login");
            String optionValueMarks = req.getParameter("marks");
            int greaterOrEqualMark = getMarks(optionValueMarks)[0];
            int lessOrEqualMark = getMarks(optionValueMarks)[1];
            ArrayList<Progress> progress = progressService.getProgressByMark(greaterOrEqualMark, lessOrEqualMark, login);
            req.setAttribute("progress", progress);
            req.getRequestDispatcher("/reportProgress.jsp").forward(req, resp);
        } else if ("markForm".equals(req.getParameter("form"))) {
            initData(req);
            String student_id = req.getParameter("student_id");
            String edate = req.getParameter("edate");
            String mark = req.getParameter("mark");
            String attendance = req.getParameter("attendance");
            if(student_id != null && edate != null) {
                progressService.addMark(student_id, edate, mark, attendance);
            }
            resp.sendRedirect(req.getContextPath() + "/inner/progress");
        }
    }

    private int[] getMarks(String marks) {
        return Arrays.stream(marks.split("\\-")).mapToInt(Integer::parseInt).toArray();
    }
}
