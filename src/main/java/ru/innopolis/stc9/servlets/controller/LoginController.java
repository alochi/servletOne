package ru.innopolis.stc9.servlets.controller;

import ru.innopolis.stc9.servlets.service.UserService;
import ru.innopolis.stc9.servlets.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {
            req.getSession().invalidate();
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    /**
     * После успешной инициализации попадаем на страницу с обзором оценок, сейчас это все что доступно для простого
     * пользователя, тогда как админу доступен сайдбар, где он может попасть на страницу редактирования студентов и т.д
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        if (userService.checkAuth(login, password)) {
            Integer role = userService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            resp.sendRedirect(req.getContextPath() + "/inner/progress");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authError");
        }
    }
}
