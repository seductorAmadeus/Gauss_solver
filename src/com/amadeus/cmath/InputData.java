package com.amadeus.cmath;

class InputData {

    private double[][] matrix;
    private double[] vectorOfValues;
    private int maxNumSize;

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

        maxNumSize = getMaxNumSize(matrix);
    }

    public double[] getVectorOfValues() {
        return vectorOfValues.clone();
    }

    public double[][] getMatrix() {
        return matrix.clone();
    }

    public int getMaxNumSize() {
        return maxNumSize;
    }

    private int getMaxNumSize(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (String.valueOf(matrix[i][j]).length() > maxNumSize) {
                    maxNumSize = String.valueOf(matrix[i][j]).length();
                }
            }
        }
        return Math.round(maxNumSize / 2);
    }
}
