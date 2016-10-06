package com.amadeus.cmath;

class OutputData {
    private static double[][] triangularMatrix;
    private static double[] vectorOfSolutions, vectorOfResiduals;

    public static void setNewOutputData(double[][] matrix) {
        triangularMatrix = matrix;
        createVectorOfSolutions(matrix[0].length);
        createVectorOfResiduals(matrix[0].length);
    }

    public static void setVectorOfResiduals(double[] vector) {
        vectorOfResiduals = vector;
    }

    private static void createVectorOfSolutions(int n) {
        vectorOfSolutions = new double[n];
    }

    public static double[] getVectorOfSolutions() {
        return vectorOfSolutions;
    }

    public static double[][] getTriangularMatrix() {
        return triangularMatrix.clone();
    }

    public static double[] getVectorOfResiduals() {
        return vectorOfResiduals.clone();
    }

    private static void createVectorOfResiduals(int n) {
        vectorOfResiduals = new double[n];
    }
}
