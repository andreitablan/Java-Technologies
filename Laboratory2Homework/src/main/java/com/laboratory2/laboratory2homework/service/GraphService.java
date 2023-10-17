package com.laboratory2.laboratory2homework.service;

import com.laboratory2.laboratory2homework.model.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GraphService {
    public Graph createGraph(InputStream fileContent) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
        int order = 0;
        int size = 0;
        boolean foundGraphDefinition = false;
        Map<Integer, Integer> edges = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("p edge")) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    try {
                        order = Integer.parseInt(parts[2]);
                        size = Integer.parseInt(parts[3]);
                        foundGraphDefinition = true;
                    } catch (NumberFormatException e) {
                    }
                }
            }

            if (foundGraphDefinition) {
                if (line.startsWith("e ")) {
                    String[] edgeParts = line.split(" ");
                    if (edgeParts.length >= 3) {
                        try {
                            int vertex1 = Integer.parseInt(edgeParts[1]);
                            int vertex2 = Integer.parseInt(edgeParts[2]);
                            edges.put(vertex1, vertex2);
                        } catch (NumberFormatException e) {

                        }
                    }
                }
            }
        }

        int[][] adjacencyMatrix = createAdjacencyMatrix(order, edges);
        return new Graph(order, size, adjacencyMatrix);
    }

    private int[][] createAdjacencyMatrix(int order, Map<Integer, Integer> edges) {
        int[][] adjacencyMatrix = new int[order][order];

        for (int line = 0; line < order; line++) {
            for (int col = 0; col < order; col++) {
                adjacencyMatrix[line][col] = 0;
            }
        }
        return adjacencyMatrix;
    }
}
