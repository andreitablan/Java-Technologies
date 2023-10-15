package com.example.lab1homework;

import java.io.*;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "generateTree", value = "/generateTree")
public class TreeAdjacencyMatrixServlet extends HttpServlet {
    /**
     * Handles HTTP GET requests.
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String httpMethod = request.getMethod();
        String ipAddress = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        Enumeration<Locale> locales = request.getLocales();
        StringBuilder languages = new StringBuilder();
        while (locales.hasMoreElements()) {
            Locale locale = locales.nextElement();
            languages.append(locale.toLanguageTag()).append(", ");
        }
        String paramValue = request.getParameter("numVertices");

        log("HTTP Method: " + httpMethod);
        log("IP Address: " + ipAddress);
        log("User-Agent: " + userAgent);
        log("Client Languages: " + languages.toString());
        log("Number of Vertices: " + paramValue);
        response.setContentType("text/html");
        if(request.getParameter("numVertices")==null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adjacencyMatrix.html");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                String numberVerticesParameter = request.getParameter("numVertices");
                int numberVertices = Integer.parseInt(numberVerticesParameter);
                int[][] adjacencyMatrix = generateRandomTreeAdjacencyMatrix(numberVertices);

                out.println("<html><body>");
                out.println("<h2>Adjacency Matrix of Random Tree with " + numberVertices + " Vertices:</h2>");
                out.println("<table border='1'>");
                out.print("<tr>");
                out.print("<th></th>");
                for (int index = 0; index < numberVertices; index++) {
                    out.print("<th>" + index + "</th>");
                }
                out.print("</tr>");
                for (int vertex = 0; vertex < numberVertices; vertex++) {
                    out.print("<tr>");
                    out.print("<th>" + vertex + "</th>");
                    for (int otherVertex = 0; otherVertex < numberVertices; otherVertex++) {
                        out.print("<td>" + adjacencyMatrix[vertex][otherVertex] + "</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body></html>");
            }
        }

    }

    /**
     * Generates a random tree adjacency matrix with the given number of vertices.
     * @param numVertices
     * @return
     */
    public static int[][] generateRandomTreeAdjacencyMatrix(int numVertices) {
        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        List<Integer> remainingVertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            remainingVertices.add(i);
        }

        Random random = new Random();
        int rootNode = random.nextInt(numVertices);
        remainingVertices.remove(Integer.valueOf(rootNode));

        Stack<Integer> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            int parent = stack.peek();
            List<Integer> potentialChildren = new ArrayList<>(remainingVertices);
            for (int child : potentialChildren) {
                if (random.nextDouble() < 0.5) {
                    adjacencyMatrix[parent][child] = 1;
                    adjacencyMatrix[child][parent] = 1;
                    stack.push(child);
                    remainingVertices.remove(Integer.valueOf(child));
                }
            }
            if (potentialChildren.isEmpty()) {
                stack.pop();
            }
        }
        return adjacencyMatrix;
    }

}