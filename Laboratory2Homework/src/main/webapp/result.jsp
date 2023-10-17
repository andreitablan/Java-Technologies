<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
