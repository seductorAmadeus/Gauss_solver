package com.amadeus.cmath;

public class GaussSolver {

    private static int i, j;
    private static double c, s;
    private static int maxStrLength = 0;

    public static int getMaxStrLength() {
        return maxStrLength;
    }

    public static void getTriangularMatrix(int n, double[][] matrix, double[] vectorOfValues) {

        int k = 0;

        for (; k < n - 1; k++) {

            i = k + 1;

            while (matrix[k][k] == 0) {
                matrix = permutationEquations(matrix, k, n);
                permutationEquations(matrix, k, n);
            }

            if (k >= n - 1) {
                break; // проверить необходимость условия
            }

            for (; i < n; i++) {

                if (i >= n) {
                    break; // проверить необходимость условия
                }

                c = matrix[i][k] / matrix[k][k];
                matrix[i][k] = 0;
                j = k + 1;

                for (; j < n; j++) {
                    matrix[i][j] = matrix[i][j] - c * matrix[k][j];
                    if (String.valueOf(matrix[i][j]).length() > maxStrLength) {
                        maxStrLength = String.valueOf(matrix[i][j]).length();
                    }
                }
                // если j < n, то
                vectorOfValues[i] = vectorOfValues[i] - c * vectorOfValues[k];
            }
        }
        OutputData.setTriangularMatrix(matrix.clone());
        OutputData.createVectorOfSolutions(n);
        OutputData.createVectorOfResiduals(n);
    }

    public static void getVectorOfResiduals(double[] vectorOfResiduals, double[] vectorOfValues, double[][] matrix, double[] vectorOfSolutions) {

        for (int n = 0; n < vectorOfResiduals.length; n++) {
            vectorOfResiduals[n] = vectorOfValues[n] - getResultOfMultiplication(n, vectorOfSolutions, matrix);
            //   System.out.println("Test №" + (n+1) + vectorOfResiduals[n] );
        }
        OutputData.setVectorOfResiduals(vectorOfResiduals);

    }

    private static double getResultOfMultiplication(int n, double[] vectorOfSolutions, double[][] parityCheckMatrix) { //original matrix
        double sum = 0.0;
        for (int i = 0; i < parityCheckMatrix[0].length - 1; i++) {
            sum += vectorOfSolutions[i] * parityCheckMatrix[n][i];
        }
        //System.out.println(sum);
        return sum;
    }

    public static void getVectorOfSolutions(int n, double[] vectorOfSolutions, double[][] matrix, double[] vectorOfValues) { // matrix == triangular matrix
        vectorOfSolutions[n - 1] = vectorOfValues[n - 1] / matrix[n - 1][n - 1];
        i = n - 1;
        for (; i > -1; i--) { // -1?
            j = i + 1;
            s = 0;
            for (; j < n; j++) {
                s = s + matrix[i][j] * vectorOfSolutions[j];
            }
            vectorOfSolutions[i] = (vectorOfValues[i] - s) / matrix[i][i];
        }
        OutputData.setVectorOfSolutions(vectorOfSolutions);
    }

    /* public static void main(String[] args) {
         GaussSolver method = new GaussSolver(6);
         double[][] testMatrix = {{1, 2, 4, 5,6, 88}, {13, 3, 13, 4, 1 ,6}, {66, 2, 4, 5, 2, 5}, {2, 1,3, 0,3,3}, {25, 66,1, 2,5,1} , {2, 51,2, 3,1,2}};
         double[] decMatrix = {-1, 2, 5, 1, 899, 2};
         method.mainAlgorithm(6, testMatrix, decMatrix);
     }
    */
    private static double[][] permutationEquations(double[][] matrix, int k, int n) {
        // k - индекс matrix[k][k] - ого элемента
        // n - число строк
        // добавить условие, что найдена строка с  нулевым элементом
        int zeroElement = 0; // 0 - временное значение
        double temp;
        for (int i = 0; i < n; i++) {
            if (matrix[i][k] == 0) {
                zeroElement = i;
                break;
            }
        }
        // пусть найдена строка с нулевым элементом
        // тогда меняем ее со строкой c индексом k
        // предположим, что n - число элементов
        // считается, что матрица [k][k]
        for (int i = 0; i < n; i++) {
            temp = matrix[zeroElement][i];
            matrix[zeroElement][i] = matrix[k][i];
            matrix[k][i] = temp;
        }
        return matrix;
    }
}
