package com.coppel.examen.filters;

import com.coppel.examen.controllers.EmpleadoController;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyRequestFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String keyAuth = req.getHeader("Authorization");

        if (keyAuth != null && !keyAuth.trim().equals("")) {
            chain.doFilter(request, response);
        } else {
            logger.error(String.format("code: %s, msg: %s", "401", "Se requiere token para la solicitud"));

            HttpServletResponse resp = (HttpServletResponse) response;

            resp.reset();
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Se requiere token para la solicitud");
        }

    }

}
