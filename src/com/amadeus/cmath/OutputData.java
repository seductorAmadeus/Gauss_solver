package com.amadeus.cmath;

class OutputData {

    static {
       createVectorOfSolutions(InputData.getDimensionOfMatrix());
       createVectorOfResiduals(InputData.getDimensionOfMatrix());
    }

    private static double[][] triangularMatrix;
    private static double[] vectorOfSolutions, vectorOfResiduals;
    private static double determinant;
    public static void setTriangularMatrix(double[][] matrix) {
        triangularMatrix = matrix;
    }

    public static void setVectorOfResiduals(double[] vector) {
        vectorOfResiduals = vector;
    }

    public static void setDeterminant(double det) {
        determinant = det;
    }
    private static void createVectorOfSolutions(int n) {
        vectorOfSolutions = new double[n];
    }

    public static double[] getVectorOfSolutions() {
        return vectorOfSolutions;
    }
    public static double getDeterminant() {
        return determinant;
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
