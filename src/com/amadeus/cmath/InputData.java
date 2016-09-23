package com.amadeus.cmath;

/**
 * Created by admin on 23.09.2016.
 */
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
}
