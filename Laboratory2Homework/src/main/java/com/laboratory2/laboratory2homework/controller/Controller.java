package com.laboratory2.laboratory2homework.controller;


import com.laboratory2.laboratory2homework.model.Graph;
import com.laboratory2.laboratory2homework.model.Input;
import com.laboratory2.laboratory2homework.model.Output;
import com.laboratory2.laboratory2homework.service.GraphService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Controller for the application.
 */
@WebServlet(name="controller", value="/controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class Controller extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Input input = new Input();
            input.setGraphFile(request.getPart("graphFile"));

            String[] selectedProperties = request.getParameterValues("properties");

            GraphService graphService = new GraphService();

            Graph graph = graphService.createGraph(input.getGraphFileInputStream());
            Output output = new Output();

            if (selectedProperties != null) {
                for (String property : selectedProperties) {
                    if ("order".equals(property)) {
                        output.setOrder(graph.getOrder());
                    }
                    if ("size".equals(property)) {
                        output.setSize(graph.getSize());
                    }
                    if ("connectedComponents".equals(property)) {
                        output.setConnectedComponents(graph.getConnectedComponents());
                    }
                    if ("minDegree".equals(property)) {
                        output.setMinDegree(graph.getMinDegree());
                    }
                    if ("maxDegree".equals(property)) {
                        output.setMaxDegree(graph.getMaxDegree());
                    }
                    if ("averageDegree".equals(property)) {
                        output.setAverageDegree(graph.getAverageDegree());
                    }
                    if ("diameter".equals(property)) {
                        output.setDiameter(graph.getDiameter());
                    }
                    if ("radius".equals(property)) {
                        output.setRadius(graph.getRadius());
                    }
                }
            }

            request.setAttribute("output", output);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            logger.severe("An error occurred in Controller: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
