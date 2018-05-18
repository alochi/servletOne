package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.pojo.Progress;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.ProgressService;
import ru.innopolis.stc9.servlets.service.ProgressServiceImpl;
import ru.innopolis.stc9.servlets.service.StudentsService;
import ru.innopolis.stc9.servlets.service.StudentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgressController  extends HttpServlet {
    private ProgressService progressService = new ProgressServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Progress> progress = progressService.getProgressByMark(0, 5);
        req.setAttribute("progress", progress);
        req.getRequestDispatcher("/reportProgress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String optionValueMarks = req.getParameter("marks");
        int greaterOrEqualMark = getMarks(optionValueMarks)[0];
        int lessOrEqualMark = getMarks(optionValueMarks)[1];

        ArrayList<Progress> progress = progressService.getProgressByMark(greaterOrEqualMark, lessOrEqualMark);
        req.setAttribute("progress", progress);
        req.getRequestDispatcher("/reportProgress.jsp").forward(req, resp);
    }

    private int[] getMarks(String marks) {
        return Arrays.stream(marks.split("\\-")).mapToInt(Integer::parseInt).toArray();
    }
}
