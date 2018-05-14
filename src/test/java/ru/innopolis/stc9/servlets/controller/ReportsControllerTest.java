package ru.innopolis.stc9.servlets.controller;

import org.junit.*;

import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReportsControllerTest {
    private ReportsController reportsController;

    @Before
    public void before(){
        this.reportsController = new ReportsController();
    }

    @Test
    public void doGetTest_MarkIsNotNull() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("")).thenReturn("5");

    }

    @Test
    public void doGetTest_MarkIsNull() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        when(httpServletRequest.getParameter("")).thenReturn(null);

        try {
            when(httpServletResponse.getWriter().toString()).thenReturn("Nothing");
            // Как тут проверить правильно? Метож ничего не вовращает, соотвтественно с чем сверить?
            this.reportsController.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
