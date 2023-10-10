package com.example.lab1homework;

import java.io.*;
import java.util.Iterator;
import java.util.function.Supplier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.util.*;
import java.util.*;
@WebServlet(name = "helloServlet", value = "/helloServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        if(request.getParameter("number")==null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/form.html");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                String number = request.getParameter("number");
                int num = Integer.parseInt(number);
                out.println("<html>");
                out.println("<head><title>Number Servlet</title></head>");
                out.println("<body>");
                out.println("<h2>Number: " + num + "</h2>");
                out.println("<ol>");
                List<Integer> digitList = new ArrayList<>();

                while (num > 0) {
                    int digit = num % 10;
                    digitList.add(digit);
                    num = num / 10;
                }

                Collections.sort(digitList);

                out.println("<ol>");
                for (int digit : digitList) {
                    out.println("<li>" + digit + "</li>");
                }
                out.println("</ol>");

                out.println("</ol>");
                out.println("</body></html>");


            }
        }

    }

    public void destroy() {
    }
}