package ru.innopolis.stc9.servlets.servlet;

import ru.innopolis.stc9.servlets.pojo.Students;
import ru.innopolis.stc9.servlets.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catId = req.getParameter("catId");
        if (catId != null) {
            Students s = itemService.getStudentById(Integer.parseInt(catId));
            resp.getWriter().println(s.getName());
        } else {
            resp.getWriter().println("Nothing");
        }
    }
}
