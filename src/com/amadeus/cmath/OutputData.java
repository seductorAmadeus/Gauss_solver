package com.amadeus.cmath;

class OutputData {

    private double[][] triangularMatrix;
    private double[] vectorOfSolutions, vectorOfResiduals, vectorOfValues;
    private double determinant;
    private int maxNumSize;

    OutputData(double[][] trMatrix, double[] vOfValues, double[] vOfSolutions, double[] vOfResiduals, double det) {
        triangularMatrix = new double[trMatrix.length][trMatrix[0].length];
        vectorOfSolutions = new double[vOfSolutions.length];
        vectorOfResiduals = new double[vOfResiduals.length];
        vectorOfValues = new double[vOfValues.length];

        for (int i = 0; i < trMatrix.length; i++) {
            for (int j = 0; j < trMatrix[0].length; j++) {
                triangularMatrix[i][j] = trMatrix[i][j];
            }
        }
        for (int i = 0; i < vOfSolutions.length; i++) {
            vectorOfSolutions[i] = vOfSolutions[i];
            vectorOfResiduals[i] = vOfResiduals[i];
            vectorOfValues[i] = vOfValues[i];
        }
        determinant = det;

        maxNumSize = getMaxNumSize(triangularMatrix);
    }

    public double getDeterminant() {
        return determinant;
    }

    public double[] getVectorOfSolutions() {
        return vectorOfSolutions;
    }

    public double[] getVectorOfResiduals() {
        return vectorOfResiduals;
    }

    public double[] getVectorOfValues() {
        return vectorOfValues;
    }

    public double[][] getTriangularMatrix() {
        return triangularMatrix;
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
        return Math.round(maxNumSize);
    }
}
