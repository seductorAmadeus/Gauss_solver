package com.amadeus.cmath;

import java.util.ArrayList;

class OutputData {

    private static double[][] triangularMatrix;
    private static double[] vectorOfSolutions, vectorOfResiduals;
    private static double determinant;

    public static void dataPack(double[][] trMatrix, double[] vOfSolutions, double[] vOfResiduals, double det) {
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

    public static ArrayList dataUnpack() {
        ArrayList data = new ArrayList();
        data.add(triangularMatrix.clone());
        data.add(vectorOfSolutions.clone());
        data.add(vectorOfResiduals.clone());
        data.add(determinant);
        return data;
    }
}
