package com.amadeus.cmath;

import java.util.Objects;

class OutputData {
    private static double[][] triangularMatrix;
    private static double[] vectorOfSolutions, vectorOfResiduals;

    public static void setTriangularMatrix(double[][] matrix) {
        triangularMatrix = matrix;
    }

    public static void setVectorOfResiduals(double[] vector) {
        vectorOfResiduals = vector;
    }

    public static void setVectorOfSolutions(double[] vector) {
        vectorOfSolutions = vector;
    }

    public static void createVectorOfSolutions(int n) {
        vectorOfSolutions = new double[n];
    }

    public static double[] getVectorOfSolutions() {
        return vectorOfSolutions.clone();

    }

    public static double[][] getTriangularMatrix() {
        return triangularMatrix.clone();
    }

    public static double[] getVectorOfResiduals() {
        return vectorOfResiduals.clone();
    }

    public static void createVectorOfResiduals(int n) {
        vectorOfResiduals = new double[n];
    }
}
