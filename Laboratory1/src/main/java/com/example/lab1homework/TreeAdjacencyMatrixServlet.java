package com.example.lab1homework;

import java.io.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "generateTree", value = "/generateTree")
public class TreeAdjacencyMatrixServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                for (int i = 0; i < numberVertices; i++) {
                    out.print("<tr>");
                    for (int j = 0; j < numberVertices; j++) {
                        out.print("<td>" + adjacencyMatrix[i][j] + "</td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</body></html>");
            }
        }

    }

    /**
     * Generates a random tree adjacency matrix with the specified number of vertices.
     * @param numberVertices the number of vertices in the tree
     * @return a random tree adjacency matrix with the specified number of vertices
     */
    private int[][] generateRandomTreeAdjacencyMatrix(int numberVertices) {
        int[][] myArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        return myArray;
    }
}