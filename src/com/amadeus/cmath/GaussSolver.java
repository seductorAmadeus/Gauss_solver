package com.amadeus.cmath;

public class GaussSolver {

    private int i, k, j;
    private double c, s;
    private double[] vectorOfSolutions, vectorOfResiduals;
    private int n;
    private double[][] matrix;
    private double[][] parityCheckMatrix;
    private double[] vectorOfValues;
    private int maxStrLength = 0;

    GaussSolver(int n, double[][] matrix, double[] vectorOfValues) {
        this.n = n;
        this.matrix = matrix;
        parityCheckMatrix = matrix.clone(); // or copy?

        this.vectorOfValues = vectorOfValues;
        vectorOfSolutions = new double[n];
        vectorOfResiduals = new double[n];
    }

    public int getMaxStrLength() {
        return maxStrLength;
    }

    public double[][] getTriangularMatrix() {

        k = 0;

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
        return matrix;

    }

    public double[] getVectorOfResiduals() {

        for (int n = 0; n < vectorOfResiduals.length; n++) {
            vectorOfResiduals[n] = vectorOfValues[n] - getResultOfMultiplication(n);
            //   System.out.println("Test №" + (n+1) + vectorOfResiduals[n] );
        }
        return vectorOfResiduals;
    }

    private double getResultOfMultiplication(int n) {
        double sum = 0.0;
        for (int i = 0; i < parityCheckMatrix[0].length - 1; i++) {
            sum += vectorOfSolutions[i] * parityCheckMatrix[n][i];
        }
        //System.out.println(sum);
        return sum;
    }

    public double[] getVectorOfSolutions() {
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
        return vectorOfSolutions;
    }

    /* public static void main(String[] args) {
         GaussSolver method = new GaussSolver(6);
         double[][] testMatrix = {{1, 2, 4, 5,6, 88}, {13, 3, 13, 4, 1 ,6}, {66, 2, 4, 5, 2, 5}, {2, 1,3, 0,3,3}, {25, 66,1, 2,5,1} , {2, 51,2, 3,1,2}};
         double[] decMatrix = {-1, 2, 5, 1, 899, 2};
         method.mainAlgorithm(6, testMatrix, decMatrix);
     }
    */
    private double[][] permutationEquations(double[][] matrix, int k, int n) {
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
