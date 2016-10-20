package com.amadeus.cmath;

import java.util.Arrays;

public class GaussSolver {

    public static OutputData solve(InputData data) {
        double[][] matrix = initMatrix(data.getMatrix());
        double[] vectorOfValues = initVectorOfValues(data.getVectorOfValues());
        double[] vectorOfSolutions = new double[vectorOfValues.length];
        int i, j, k = 0, n = matrix.length;

        for (; k < n - 1; k++) {

            i = k + 1;

            while (matrix[k][k] == 0) {
                matrix = permutationEquations(matrix, k, n);
            }

            for (; i < n; i++) {

                double c = matrix[i][k] / matrix[k][k];
                matrix[i][k] = 0;
                j = k + 1;

                for (; j < n; j++) {
                    matrix[i][j] = matrix[i][j] - c * matrix[k][j];
                }
                vectorOfValues[i] = vectorOfValues[i] - c * vectorOfValues[k];
            }
        }

        vectorOfSolutions[n - 1] = vectorOfValues[n - 1] / matrix[n - 1][n - 1];
        i = n - 1;
        for (; i > -1; i--) {
            j = i + 1;
            double s = 0;
            for (; j < n; j++) {
                s = s + matrix[i][j] * vectorOfSolutions[j];
            }
            vectorOfSolutions[i] = (vectorOfValues[i] - s) / matrix[i][i];
        }
        return new OutputData(matrix, vectorOfSolutions, getVectorOfResiduals(vectorOfValues, matrix, vectorOfSolutions), calculateDeterminant(matrix));
    }

    private static double[] getVectorOfResiduals(double[] originalVectorOfValues, double[][] originalMatrix, double[] vectorOfSolutions) {
        double[] vectorOfResiduals = new double[originalMatrix.length];
        double[][] matrix = initMatrix(originalMatrix);
        double[] vectorOfValues = initVectorOfValues(originalVectorOfValues);
        for (int n = 0; n < vectorOfResiduals.length; n++) {
            vectorOfResiduals[n] = vectorOfValues[n] - getResultOfMultiplication(n, vectorOfSolutions, matrix);
        }
        return vectorOfResiduals;
    }

    private static double calculateDeterminant(double[][] triangularMatrix) {
        double determinant = 1;
        for (int i = 0; i < triangularMatrix[0].length; i++) {
            determinant *= triangularMatrix[i][i];
        }
        return determinant;
    }

    private static double getResultOfMultiplication(int n, double[] vectorOfSolutions, double[][] originalMatrix) {
        double sum = 0.0;
        for (int i = 0; i < originalMatrix[0].length; i++) {
            sum += vectorOfSolutions[i] * originalMatrix[n][i];
        }
        return sum;
    }

    private static double[][] permutationEquations(double[][] matrix, int k, int n) {
        int zeroElement = 0;
        double temp;
        for (int i = 0; i < n; i++) {
            if (matrix[i][k] == 0) {
                zeroElement = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            temp = matrix[zeroElement][i];
            matrix[zeroElement][i] = matrix[k][i];
            matrix[k][i] = temp;
        }
        return matrix;
    }

    private static double[][] initMatrix(double[][] originalMatrix) {
        if (originalMatrix == null) {
            return null;
        }
        final double[][] matrix = new double[originalMatrix.length][];
        for (int i = 0; i < originalMatrix.length; i++) {
            matrix[i] = Arrays.copyOf(originalMatrix[i], originalMatrix[i].length);
        }
        return matrix;
    }

    private static double[] initVectorOfValues(double[] originalVectorOfValues) {
        if (originalVectorOfValues == null) {
            return null;
        }
        double[] vectorOfValues;
        vectorOfValues = Arrays.copyOf(originalVectorOfValues, originalVectorOfValues.length);
        return vectorOfValues;
    }
}
