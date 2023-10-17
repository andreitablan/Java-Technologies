package com.laboratory2.laboratory2homework.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Filter for logging requests.
 */
@WebFilter(filterName = "LogRequest")
public class LogRequest implements Filter {
    private static final Logger logger = Logger.getLogger(LogRequest.class.getName());

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info("Received a request: " + request.getRemoteAddr() + " " + request.getRemoteHost());
        chain.doFilter(request, response);
    }
}
