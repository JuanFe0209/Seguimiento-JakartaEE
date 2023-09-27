package com.example.utils;

import com.example.domain.exceptions.ServiceJdbcException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain
            chain) throws IOException, ServletException {
        try (Connection con = ConexionBaseDatos.getConnection()){
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                request.setAttribute("con", con);
                chain.doFilter(request, response);
                con.commit();
            } catch (SQLException | ServiceJdbcException e) {
                con.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException throwable) {
            throw new ServiceJdbcException("Unable to connect the filter");
        }
    }
}