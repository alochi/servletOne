package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.pojo.Exercises;
import ru.innopolis.stc9.servlets.pojo.Subjects;
import ru.innopolis.stc9.servlets.service.ExercisesService;
import ru.innopolis.stc9.servlets.service.ExercisesServiceImpl;
import ru.innopolis.stc9.servlets.service.SubjectsService;
import ru.innopolis.stc9.servlets.service.SubjectsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExercisesController extends HttpServlet {
    private ExercisesService exercisesService = new ExercisesServiceImpl();
    private SubjectsService subjectsService = new SubjectsServiceImpl();

    /**
     * subjects нам нужен для формирования выпадающего списка в форме добавления новой записи (60 строка reportExercises.jsp)
     * В остальном выводим таблицу
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Subjects> subjects = subjectsService.getSubjects();
        ArrayList<Exercises> exercises = exercisesService.getExercises();
        req.setAttribute("exercises", exercises);
        req.setAttribute("subjects", subjects);
        req.setAttribute("role", req.getSession().getAttribute("role"));

        req.getRequestDispatcher("/reportExercises.jsp").forward(req, resp);
    }

    /**
     * Собираем данные со страницы, формируем объект Exercises, закидываем в exercisesService
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("addForm".equals(req.getParameter("form"))) {
            int subject_id = Integer.parseInt(req.getParameter("subject_id"));
            String date = req.getParameter("date");
            String exercise = req.getParameter("exercise");
            Exercises exer = new Exercises(subject_id, date, exercise);
            if (!exercise.equals("")) {
                exercisesService.addExercise(exer);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/inner/exercises");
    }
}
