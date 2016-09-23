package com.amadeus.cmath;

class InputData {
    private static double[][] matrix;
    private static double[]  vectorOfValues;
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

    public static double[] getVectorOfValues() {
        return vectorOfValues.clone();
    }

    public static void createMatrix() {
        matrix = new double[n][n + 1];
    }

    public static void createVectorOfValues() {
        vectorOfValues = new double[matrix.length];
    }

    public static void allocateVectorOfValues() {
        for (int i = 0; i < matrix[0].length - 1; i++) {
            vectorOfValues[i] = matrix[i][matrix[0].length - 1];
        }
    }

}
