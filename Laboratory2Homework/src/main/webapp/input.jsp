<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Graph Properties</title>
</head>
<body>
<h2>Graph Properties:</h2>
<form action="graphServlet" method="post">
    <label for="graphFile">Upload a graph (DIMACS format):</label>
    <br>
    <input type="file" name="graphFile" id="graphFile">
    <br>
    <label for="graphProperty">Select Graph Property:</label>
    <select name="graphProperty" id="graphProperty">
        <option value="order" selected>Order (Number of Vertices)</option>
        <option value="size">Size (Number of Edges)</option>
        <option value="connectedComponents">Number of Connected Components</option>
        <option value="minMaxAverageDegree">Min/Max/Average Degree</option>
        <option value="diameter">Diameter</option>
        <option value="radius">Radius</option>
    </select>
    <br>
    <input type="submit" value="Upload and Show Property">
</form>
</body>
</html>
