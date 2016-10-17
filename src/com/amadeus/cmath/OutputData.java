package com.amadeus.cmath;

class OutputData {

    private static double[][] triangularMatrix;
    private static double[] vectorOfSolutions, vectorOfResiduals;
    private static double determinant;

    public double getDeterminant() {
        return determinant;
    }

    public double[] getVectorOfSolutions() {
        return vectorOfSolutions;
    }

    public double[] getVectorOfResiduals() {
        return vectorOfResiduals;
    }

    public double[][] getTriangularMatrix() {
        return triangularMatrix;
    }

    OutputData(double[][] trMatrix, double[] vOfSolutions, double[] vOfResiduals, double det) {
        triangularMatrix = new double[trMatrix.length][trMatrix[0].length];
        vectorOfSolutions = new double[vOfSolutions.length];
        vectorOfResiduals = new double[vOfResiduals.length];

        for (int i = 0; i < trMatrix.length; i++) {
            for (int j = 0; j < trMatrix[0].length; j++) {
                triangularMatrix[i][j] = trMatrix[i][j];
            }
        }
        for (int i = 0; i < vOfSolutions.length; i++) {
            vectorOfSolutions[i] = vOfSolutions[i];
            vectorOfResiduals[i] = vOfResiduals[i];
        }
        determinant = det;

    }

}
