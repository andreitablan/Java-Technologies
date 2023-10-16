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
            String selectedProperty = request.getParameter("graphProperty");
            logger.info("Selected property: " + selectedProperty);
            if ("order".equals(selectedProperty)) {
                int order = 1;
                request.setAttribute("order", order);
            }
            if ("size".equals(selectedProperty)) {
                int size = 10;
                request.setAttribute("size", size);
            }
            if ("connectedComponents".equals(selectedProperty)) {
                int connectedComponents = 2;
                request.setAttribute("connectedComponents", connectedComponents);
            }
            if ("minMaxAverageDegree".equals(selectedProperty)) {
                int minMaxAverageDegree = 3;
                request.setAttribute("minMaxAverageDegree", minMaxAverageDegree);
            }
            if ("diameter".equals(selectedProperty)) {
                int diameter = 4;
                request.setAttribute("diameter", diameter);
            }
            if ("radius".equals(selectedProperty)) {
                int radius = 5;
                request.setAttribute("radius", radius);
            }
            request.setAttribute("property", selectedProperty);

            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            logger.severe("An error occurred in GraphPropertiesServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }
}
