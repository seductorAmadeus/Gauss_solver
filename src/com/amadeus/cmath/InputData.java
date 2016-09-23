package com.amadeus.cmath;

class InputData {
    private double[][] matrix;
    private double[] vectorOfSolutions, vectorOfResiduals, vectorOfValues;
    private int n; // dimension

    public void fillMatrix(int i, int j, double value) {
        matrix = new double[n][n+1];
        matrix[i][j] = value;
    }

    public void setDimensionOfMatrix(int n) {
        this.n = n;
    }
    public int getDimensionOfMatrix() {
        return n;
    }
    public double[][] getMatrix () {
        return matrix.clone();
    }

    public void allocateVectorOfValues() {
        vectorOfValues = new double[matrix.length];
        for (int i = 0; i < matrix[0].length - 1; i++) {
            vectorOfValues[i] = matrix[i][matrix[0].length - 1];
        }
    }

}
