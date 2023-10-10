<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Graph in DIMACS Format</title>
</head>
<body>
<h1>Upload Graph in DIMACS Format</h1>
<form action="upload"> " method="post" enctype="multipart/form-data">
    <label for="file">Select a file:</label>
    <input type="file" id="file" name="file"><br><br>
    <input type="submit" value="Upload">
</form>
</body>
</html>