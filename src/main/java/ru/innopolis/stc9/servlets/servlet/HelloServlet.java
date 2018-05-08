package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.pojo.Progress;
import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class HelloServlet extends HttpServlet {
    private ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mark = req.getParameter("mark");
        if (mark != null) {
            ArrayList<Progress> progresses = itemService.getStudentById(Integer.parseInt(mark));
            for (Progress progress : progresses) {
                resp.getWriter().println(progress.getStudents_name() + ", " +
                        progress.getExercises_name() + ", " +
                        progress.getDate());
            }

        } else {
            resp.getWriter().println("Nothing");
        }
    }
}
