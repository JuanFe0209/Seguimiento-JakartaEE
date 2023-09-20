package com.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value="/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // Establece el tipo de contenido de la respuesta como HTML
        resp.setContentType("text/html");
        // Recopila información sobre la solicitud HTTP entrante
        // Obtiene el método HTTP
        String metodoHttp = req.getMethod();
        // Obtiene la URI de la solicitud
        String requestUri = req.getRequestURI();
        // Obtiene la URL de la solicitud
        String requestUrl = req.getRequestURL().toString();
        // Obtiene el contexto de la aplicación.
        String contexPath = req.getContextPath();
        // Obtiene la ruta del servlet
        String servletPath = req.getServletPath();
        // Obtiene la dirección IP del cliente.
        String ipCliente = req.getRemoteAddr();
        // Obtiene la dirección IP local.
        String ip = req.getLocalAddr();
        // Obtiene el puerto local.
        int port = req.getLocalPort();
        // Obtiene el esquema (http o https) de la solicitud.
        String scheme = req.getScheme();
        // Obtiene el encabezado "host" de la solicitud HTTP.

        // Construye URL personalizadas para utilizar en la respuesta.
        String host = req.getHeader("host");
        String url = scheme + "://" + host + contexPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;

        // Genera una página HTML para mostrar la información de la solicitud HTTP.
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Cabeceras HTTP Request</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>context path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");

            // Enumera todas las cabeceras HTTP de la solicitud.
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>"+ cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }

    }
}


