<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Graph Properties</title>
</head>
<body>
<h1>Graph Properties</h1>

<%
  int order = (int) request.getAttribute("order");
  int size = (int) request.getAttribute("size");
  int numComponents = (int) request.getAttribute("numComponents");
  int minDegree = (int) request.getAttribute("minDegree");
  int maxDegree = (int) request.getAttribute("maxDegree");
  double avgDegree = (double) request.getAttribute("avgDegree");
  int diameter = (int) request.getAttribute("diameter");
  int radius = (int) request.getAttribute("radius");
%>

<%-- Display graph properties --%>
<p>Order: <%= order %></p>
<p>Size: <%= size %></p>
<p>Number of Connected Components: <%= numComponents %></p>
<p>Minimum Degree: <%= minDegree %></p>
<p>Maximum Degree: <%= maxDegree %></p>
<p>Average Degree: <%= avgDegree %></p>
<p>Diameter: <%= diameter %></p>
<p>Radius: <%= radius %></p>

</body>
</html>

