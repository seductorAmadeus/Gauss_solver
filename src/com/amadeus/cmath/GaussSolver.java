package com.amadeus.cmath;

public class GaussSolver {

    private static int i, j;
    private static double c, s;

    public static void runGaussMethod(int n, double[][] originalMatrix, double[] originalVectorOfValues, double[] vectorOfSolutions) {
        double[][] matrix = initMatrix(originalMatrix);
        double[] vectorOfValues = initVectorOfValues(originalVectorOfValues);
        int k = 0;
        for (; k < n - 1; k++) {

            i = k + 1;

            while (matrix[k][k] == 0) {
                matrix = permutationEquations(matrix, k, n);
            }

            for (; i < n; i++) {

                c = matrix[i][k] / matrix[k][k];
                matrix[i][k] = 0;
                j = k + 1;

                for (; j < n; j++) {
                    matrix[i][j] = matrix[i][j] - c * matrix[k][j];
                }
                vectorOfValues[i] = vectorOfValues[i] - c * vectorOfValues[k];
            }
        }

        OutputData.setTriangularMatrix(matrix.clone());
        OutputData.setDeterminant(calculateDeterminant(matrix));

        vectorOfSolutions[n - 1] = vectorOfValues[n - 1] / matrix[n - 1][n - 1];
        i = n - 1;
        for (; i > -1; i--) {
            j = i + 1;
            s = 0;
            for (; j < n; j++) {
                s = s + matrix[i][j] * vectorOfSolutions[j];
            }
            vectorOfSolutions[i] = (vectorOfValues[i] - s) / matrix[i][i];
        }
    }

    public static void getVectorOfResiduals(double[] vectorOfResiduals, double[] originalVectorOfValues, double[][] originalMatrix, double[] vectorOfSolutions) {
        double[][] matrix = initMatrix(originalMatrix);
        double[] vectorOfValues = initVectorOfValues(originalVectorOfValues);
        for (int n = 0; n < vectorOfResiduals.length; n++) {
            vectorOfResiduals[n] = vectorOfValues[n] - getResultOfMultiplication(n, vectorOfSolutions, matrix);
        }
        OutputData.setVectorOfResiduals(vectorOfResiduals);
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
        double[][] matrix = new double[originalMatrix.length][originalMatrix[0].length];
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[0].length; j++) {
                matrix[i][j] = originalMatrix[i][j];
            }
        }
        return matrix;
    }

    private static double[] initVectorOfValues(double[] originalVectorOfValues) {
        double[] vectorOfValues = new double[originalVectorOfValues.length];
        for (int i = 0; i < vectorOfValues.length; i++) {
            vectorOfValues[i] = originalVectorOfValues[i];
        }
        return vectorOfValues;
    }
}
