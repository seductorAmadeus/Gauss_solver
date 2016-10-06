package com.amadeus.cmath;


class InputData {
    private static double[][] matrix, originalMatrix;
    private static double[] vectorOfValues;
    private static int n; // dimension

    public static void fillMatrix(int i, int j, double value) {
        matrix[i][j] = value;
    }

    public static void setDimensionOfMatrix(int dimension) {
        n = dimension;
    }

    public static int getDimensionOfMatrix() {
        return n;
    }

    public static double[][] getMatrix() {
        return matrix.clone();
    }

    public static double[][] getOriginalMatrix() {
        return originalMatrix.clone();
    }

    public static void fillVectorOfValues(int i, double value) {
        vectorOfValues[i] = value;
    }

    public static double[] getVectorOfValues() {
        return vectorOfValues;
    }

    public static void createMatrix() {
        matrix = new double[n][n];
        originalMatrix = new double[n][n];
    }

    public static void createVectorOfValues() {
        vectorOfValues = new double[matrix.length];
    }


    public static void copyMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                originalMatrix[i][j] = matrix[i][j];
            }
        }
    }

}
