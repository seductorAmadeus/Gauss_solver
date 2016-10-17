package com.amadeus.cmath;

import java.util.ArrayList;

class InputData {
    private static double[][] matrix;
    private static double[] vectorOfValues;

    public static void dataPack(double[][] originalMatrix, double[] originalVectorOfValues) {
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
    }

    public static ArrayList dataUnpack() {
        ArrayList data = new ArrayList();
        data.add(matrix.clone());
        data.add(vectorOfValues.clone());
        return data;
    }
}
