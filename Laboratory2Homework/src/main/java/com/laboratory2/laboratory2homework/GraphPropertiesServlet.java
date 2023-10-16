package com.laboratory2.laboratory2homework;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name="graphServlet", value="/graphServlet")
public class GraphPropertiesServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(GraphPropertiesServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part filePart = request.getPart("graphFile");
            int order = 1;
            int size = 10;

            request.setAttribute("order", order);
            request.setAttribute("size", size);

            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            logger.severe("An error occurred in GraphPropertiesServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }
}
