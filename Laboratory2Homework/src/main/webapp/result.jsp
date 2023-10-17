<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Graph Properties</title>
</head>
<body>
<h2>Graph Properties:</h2>
<ul>
  <li>Order (Number of Vertices): ${output.getOrder()}</li>
  <li>Size (Number of Edges): ${output.getSize()}</li>
  <li>Number of Connected Components: ${output.getConnectedComponents()}</li>
  <li>Min Degree: ${output.getMinDegree()}</li>
  <li>Max Degree: ${output.getMaxDegree()}</li>
  <li>Average Degree: ${output.getAverageDegree()}</li>
  <li>Diameter: ${output.getDiameter()}</li>
  <li>Radius: ${output.getRadius()}</li>
</ul>
</body>
</html>
