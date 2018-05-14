package ru.innopolis.stc9.servlets.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.servlets.pojo.Progress;
import ru.innopolis.stc9.servlets.service.ItemService;
import ru.innopolis.stc9.servlets.service.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ReportsController extends HttpServlet {
    final static Logger LOGGER = Logger.getLogger(ReportsController.class);
    private ItemService itemService = new ItemServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mark = req.getParameter("mark");
        if (mark != null) {
            ArrayList<Progress> progresses = itemService.getStudentById(Integer.parseInt(mark));
            for (Progress progress : progresses) {
                String result = progress.getStudents_name() + ", " +
                        progress.getSubject() + ": (" +
                        progress.getExercises_name() + "), " +
                        progress.getDate();
                //req.setAttribute ("mark", result);
                //LOGGER.info("Mark:" + mark + " (" + result + ")");
            }
            req.setAttribute ("mark", progresses);
        } else {
            req.setAttribute ("mark", "Nothing");
            //LOGGER.info("Mark: null - (Nothing)");
        }

        req.getRequestDispatcher("/reports.jsp").forward(req, resp);
    }
}
