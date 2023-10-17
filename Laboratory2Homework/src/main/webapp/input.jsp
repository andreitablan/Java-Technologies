<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
<h2>Graph Properties:</h2>
<form action="controller" method="post" enctype="multipart/form-data">
    <label for="graphFile">Upload a graph (DIMACS format):</label>
    <br>
    <input type="file" name="graphFile" id="graphFile">
    <br>
    <label>Select Graph Property:</label>
    <br>
    <input type="checkbox" name="properties" value="order" id="orderCheckbox"> Order (Number of Vertices)<br>
    <input type="checkbox" name="properties" value="size" id="sizeCheckbox"> Size (Number of Edges)<br>
    <input type="checkbox" name="properties" value="connectedComponents" id="connectedComponentsCheckbox"> Number of Connected Components<br>
    <input type="checkbox" name="properties" value="minDegree" id="minDegreeCheckbox"> Min Degree<br>
    <input type="checkbox" name="properties" value="maxDegree" id="maxDegreeCheckbox"> Max Degree<br>
    <input type="checkbox" name="properties" value="averageDegree" id="averageDegreeCheckbox"> Average Degree<br>
    <input type="checkbox" name="properties" value="diameter" id="diameterCheckbox"> Diameter<br>
    <input type="checkbox" name="properties" value="radius" id="radiusCheckbox"> Radius<br>
    <br>
    <input type="submit" value="Upload and Show Property">
</form>
</body>
</html>
