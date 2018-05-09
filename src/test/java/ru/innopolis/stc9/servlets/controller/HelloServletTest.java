package ru.innopolis.stc9.servlets.controller;

import org.junit.*;
import ru.innopolis.stc9.servlets.controller.HelloServlet;

import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServletTest {
    private HelloServlet helloServlet;

    @Before
    public void before(){
        this.helloServlet = new HelloServlet();
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
            this.helloServlet.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
