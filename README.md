# Java Technologies
- Laboratories for the Java Technologies course at the Faculty of Computer Science Iasi.
- [Couse page](https://profs.info.uaic.ro/~acf/tj/)

## Laboratory 1
- **Compulsory:**
	I finished the compulsory. I had some problems with the project, when I pressed Submit on the form I was redirected to an error page 404, and even though I tried to change the servlet setup, it did not work.
- **Homework:**
	I finished all 3 points of the homework. I implemented another servlet in the same project (*Laboratory1*).
	- I created a method called *generateRandomTreeAdjacencyMatrix* in the servlet that generates an adjacency matrix with the given number of vertices.
 	- I printed the HTTP method used, the IP-address of the client, the user-agent, the client language and the parameter of the request (*numVertices*) in the log file of the GlassFish. This file is not uploaded on GitHub, but I will if necessary. An example of an instance is *[2023-10-15T12:28:05.079353+03:00] [GF 7.0.9] [INFO] [] [jakarta.enterprise.web.vs.server] [tid: _ThreadID=37 _ThreadName=http-listener-1(1)] [levelValue: 800] [[
  WebModule[/lab1-homework-1.0-SNAPSHOT] ServletContext.log():generateTree&#x3a; Number of Vertices&#x3a; 6]]*
	- I created a Python project named *Laboratory1HomeworkPart3* for the invocation of the servlet from a different desktop application. I tested it and it worked. 

## Laboratory 2
- **Compulsory:**
         I finished part of the compulsory, in the *Lab2* project only sending one parameter from one .jsp file to another. 
- **Homework**
  	I started the homework in the *Laboratory2Homework* project. I had the same problem as in the last laboratory, but now I have solved it (it was something regarding the project's configuration). The only thing that I did not finish represents some properties of a graph.
  	- The application is able to receive and parse a file in the specified format. It displays the *order* and *size* of a graph on the *result.jsp* page. The client can choose what to display.
  	- The application is created on an object-oriented domain model, having classes such as Input and Output
	- It also has a server-side component for the business-logic, called GraphService; a server-side component responsible with controlling the web-flow, Controller which is the servlet; a Graph class representing a graph, and two web filters, one for logging all requests received by *input.jsp* (example *[2023-10-17T15:18:46.765981+03:00] [GF 7.0.9] [INFO] [][com.laboratory2.laboratory2homework.filters.LogRequest] [tid: _ThreadID=41 _ThreadName=http-listener-1(5)] [levelValue: 800] [[
  Received a request: 0:0:0:0:0:0:0:1 0:0:0:0:0:0:0:1]]*); and a filter for decorating the response. 

## Laboratory 3
- **Compulsory:**
         I started the compulsory in the *Lab3* project. I had to change to Wildfly in order to make it work. I created the JSF project and the PostgreSQL database with two tables.
- **Homework**
  	Work in progress
