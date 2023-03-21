package com.coppel.examen.filters;

import com.coppel.examen.controllers.EmpleadoController;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
@Component
public class ApiKeyRequestFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(EmpleadoController.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String keyAuth = req.getHeader("Authorization");
        logger.info(keyAuth);

        if (keyAuth != null && !keyAuth.trim().equals("")) {
            chain.doFilter(request, resp);
        } else {
            logger.error(String.format("code: %s, msg: %s", "401", "Se requiere token para la solicitud"));

            resp.reset();
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            response.getWriter().write("Se requiere token para la solicitud");
        }

    }

}
 */
