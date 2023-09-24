package com.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Refresh {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh", "1");
        LocalTime hora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>La hora actualizada</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>La hora actualizada!</h1>");
            out.println("<h3>" + hora.format(df) + "</h3>");
            out.println(" </body>");
            out.println("</html>");
            //getRequestDispatcher se utiliza para transferir el control al recurso dentro del servidor, por lo general, a otro servlet o a una página JSP dentro de la misma aplicación web
            req.getServletContext().getRequestDispatcher("/students.html").forward(req, resp);
            //sendRedirect se utiliza para redireccionar a los clientes del navegador a una nueva URL. Puede ser una URL dentro de la misma aplicación web o una URL externa.
            resp.sendRedirect(req.getContextPath() + "/students.html");

        }
    }
}
