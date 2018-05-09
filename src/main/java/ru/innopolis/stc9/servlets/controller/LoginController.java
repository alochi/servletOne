package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Hello!");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        if (userService.checkAuth(login, password)) {
            req.getSession().setAttribute("login", login);
            resp.sendRedirect(req.getContextPath() + "/inner/dashboard");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authError");
        }
    }
}
