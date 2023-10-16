<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Graph Properties</title>
</head>
<body>
<h1>Graph Properties</h1>
<%
  int size = (int) request.getAttribute("size");
%>
<p>Uploaded file size: <%= size %></p>
</body>
</html>
