<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Send Parameter</title>
</head>
<body>
<h1>Send Parameter</h1>
<form action="result.jsp" method="get">
    <label for="parameter">Enter a parameter:</label>
    <input type="text" id="parameter" name="param">
    <br><br>
    <input type="submit" value="Send">
</form>
</body>
</html>