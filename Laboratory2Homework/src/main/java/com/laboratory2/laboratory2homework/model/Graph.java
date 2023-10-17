package com.laboratory2.laboratory2homework.model;

public class Graph {
    private int order;
    private int size;
    private int connectedComponents;
    private int minDegree;
    private int maxDegree;
    private double averageDegree;
    private int diameter;
    private int radius;
    private int[][] adjacencyMatrix;
    public Graph(int numberOfVertices, int size, int[][] adjacencyMatrix) {
        this.order = numberOfVertices;
        this.size = size;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getConnectedComponents() {
        return connectedComponents;
    }

    public void setConnectedComponents(int connectedComponents) {
        this.connectedComponents = connectedComponents;
    }

    public int getMinDegree() {
        return minDegree;
    }

    public void setMinDegree(int minDegree) {
        this.minDegree = minDegree;
    }

    public int getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(int maxDegree) {
        this.maxDegree = maxDegree;
    }

    public double getAverageDegree() {
        return averageDegree;
    }

    public void setAverageDegree(double averageDegree) {
        this.averageDegree = averageDegree;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
