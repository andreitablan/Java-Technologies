<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Input</title>
</head>
<body>
<h1>Send Input</h1>
<form action="graphServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="graphFile" />
    <br><br>
    <input type="submit" value="Upload">
</form>
</body>
</html>