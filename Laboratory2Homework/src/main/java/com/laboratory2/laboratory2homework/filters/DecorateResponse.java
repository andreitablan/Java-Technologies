package com.laboratory2.laboratory2homework.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Filter for decorating the response.
 */
@WebFilter(filterName = "DecorateResponse", urlPatterns = {"/*"})
public class DecorateResponse implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        CharArrayWriter charArray = new CharArrayWriter();
        PrintWriter charArrayWriter = new PrintWriter(charArray);

        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper((HttpServletResponse) response) {
            @Override
            public PrintWriter getWriter() {
                return charArrayWriter;
            }
        };

        chain.doFilter(request, responseWrapper);

        String responseContent = charArray.toString();

        String decoratedResponse = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>This is Homework 2</title>" +
                "</head>" +
                "<body>" +
                "Welcome!" +
                responseContent +
                "<p> Thank you!" +
                "</body>" +
                "</html>";

        PrintWriter originalWriter = response.getWriter();
        originalWriter.write(decoratedResponse);
    }
}
