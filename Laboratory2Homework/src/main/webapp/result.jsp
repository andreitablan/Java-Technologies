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
  <li>Order (Number of Vertices): ${order}</li>
  <li>Size (Number of Edges): ${size}</li>
  <li>Number of Connected Components: ${connectedComponents}</li>
  <li>minMaxAverageDegree Degree: ${minMaxAverageDegree}</li>
  <li>Average Degree: ${averageDegree}</li>
  <li>Diameter: ${diameter}</li>
  <li>Radius: ${radius}</li>
</ul>
</body>
</html>
