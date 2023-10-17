package com.laboratory2.laboratory2homework;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name="graphServlet", value="/graphServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class GraphPropertiesServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(GraphPropertiesServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part filePart = request.getPart("graphFile");
            String[] selectedProperties = request.getParameterValues("properties");

            InputStream fileContent = filePart.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
            int order = 0;
            int size = 0;
            int connectedComponents = 0;
            int minMaxAverageDegree = 0;
            int diameter = 0;
            int radius = 0;

            boolean foundGraphDefinition = false;
            Map<Integer, Integer> edges = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("p edge")) {
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        try {
                            order = Integer.parseInt(parts[2]);
                            size = Integer.parseInt(parts[3]);
                            foundGraphDefinition = true;
                        } catch (NumberFormatException e) {
                        }
                    }
                }

                if (foundGraphDefinition) {
                    if (line.startsWith("e ")) {
                        String[] edgeParts = line.split(" ");
                        if (edgeParts.length >= 3) {
                            try {
                                int vertex1 = Integer.parseInt(edgeParts[1]);
                                int vertex2 = Integer.parseInt(edgeParts[2]);
                                edges.put(vertex1, vertex2);
                            } catch (NumberFormatException e) {

                            }
                        }
                    }
                }
            }
            if (selectedProperties != null) {
                for (String property : selectedProperties) {
                    if ("order".equals(property)) {
                        request.setAttribute("order", order);
                    }
                    if ("size".equals(property)) {
                        request.setAttribute("size", size);
                    }
                    if ("connectedComponents".equals(property)) {
                        request.setAttribute("connectedComponents", connectedComponents);
                    }
                    if ("minMaxAverageDegree".equals(property)) {
                        request.setAttribute("minMaxAverageDegree", minMaxAverageDegree);
                    }
                    if ("diameter".equals(property)) {
                        request.setAttribute("diameter", diameter);
                    }
                    if ("radius".equals(property)) {
                        request.setAttribute("radius", radius);
                    }
                }
            }
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            logger.severe("An error occurred in GraphPropertiesServlet: " + e.getMessage());
            e.printStackTrace();
            response.sendRedirect("/error.jsp");
        }
    }
}
