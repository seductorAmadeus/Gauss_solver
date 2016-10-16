package com.amadeus.cmath;


class InputData {
    private static double[][] matrix;
    private static double[] vectorOfValues;
    private static int n; // dimension

    public static void fillMatrix(int i, int j, double value) {
        matrix[i][j] = value;
    }

    public static void createNewMatrices(int dimension) {
        n = dimension;
        createMatrix();
        createVectorOfValues();
    }

    public static int getDimensionOfMatrix() {
        return n;
    }

    public static double[][] getMatrix() {
        return matrix.clone();
    }

    public static void fillVectorOfValues(int i, double value) {
        vectorOfValues[i] = value;
    }

    public static double[] getVectorOfValues() {
        return vectorOfValues;
    }

    private static void createMatrix() {
        matrix = new double[n][n];
    }

    private static void createVectorOfValues() {
        vectorOfValues = new double[matrix.length];
    }


}
