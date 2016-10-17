package com.amadeus.cmath;

class InputData {
    private static double[][] matrix;
    private static double[] vectorOfValues;
    private static int n;

    InputData(double[][] originalMatrix, double[] originalVectorOfValues) {
        matrix = new double[originalMatrix.length][originalMatrix[0].length];
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[0].length; j++) {
                matrix[i][j] = originalMatrix[i][j];
            }
        }

        vectorOfValues = new double[originalVectorOfValues.length];
        for (int i = 0; i < vectorOfValues.length; i++) {
            vectorOfValues[i] = originalVectorOfValues[i];
        }
        n = matrix.length;
    }

    public double[] getVectorOfValues() {
        return vectorOfValues.clone();
    }

    public double[][] getMatrix() {
        return matrix.clone();
    }

    public int getDimension() {
        return n;
    }

}
