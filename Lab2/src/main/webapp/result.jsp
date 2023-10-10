<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Received Parameter</title>
</head>
<body>
<h1>Received Parameter</h1>

<%
  String parameter = request.getParameter("param");
%>

<%-- Display the received parameter --%>
<p>Parameter: <%= parameter %></p>

</body>
</html>
