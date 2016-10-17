package com.amadeus.cmath;

import java.util.ArrayList;

public class MatrixPrinter {

    private static int PRECISION = 3;
    private static String templateOutputString = "%#.&f";

    private static int getMaxStrLength(ArrayList data) {
        double[][] matrix = new double[((double[][]) data.get(0)).length][((double[][]) data.get(0)).length];
        int maxStrLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (String.valueOf(matrix[i][j]).length() > maxStrLength) {
                    maxStrLength = String.valueOf(matrix[i][j]).length();
                }
            }
        }
        return maxStrLength * PRECISION;
    }

    private static void printVector(double[] array, String maxSize, String format) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&", String.valueOf(PRECISION)).replace("f", format);
        for (int i = 0; i < array.length; i++) {
            System.out.printf(templateOutputString, array[i] + 0.0);
            System.out.println();
        }
        System.out.println();
    }

    public static void printInputData(ArrayList inputData) {
        String maxStringLength = String.valueOf(getMaxStrLength(inputData));
        System.out.println("\nAugmented matrix of the system: ");
        printMatrix((double[][]) inputData.get(0), (double[]) inputData.get(1), maxStringLength);
    }

    public static void printOutputData(ArrayList outputData) {
        String maxStringLength = String.valueOf(getMaxStrLength(outputData));
        System.out.println("\nTriangular matrix of system: ");
        printTriangularMatrix((double[][]) outputData.get(0), maxStringLength);
        System.out.println("Determinant: " + (double) outputData.get(3));
        System.out.println("\nVector of solutions: ");
        printVector((double[]) outputData.get(1), maxStringLength, "f");
        System.out.println("Vector of residuals: ");
        printVector((double[]) outputData.get(2), maxStringLength, "e");
    }

    public static void printMainMenu(InputType type) {
        System.out.println("Input mode = " +
                type.getName() + "\n" +
                "1 : Change input type:\n" +
                "2 : Enter new data\n" +
                "3 : Run Gauss method\n" +
                "4 : Exit\n" +
                "Enter menu item:\n");

    }

    public static void printSideMenu() {
        System.out.println("1 : Input from the command line \n" +
                "2 : Input from the (txt) file \n" +
                "3 : Fill the matrix with random coefficients \n" +
                "Enter menu item:\n");
    }

    private static void printMatrix(double[][] array, double[] vectorOfValues, String maxSize) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&", String.valueOf(PRECISION));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length + 1; j++) {
                if (j + 1 >= array[0].length + 1) {
                    System.out.printf(templateOutputString, vectorOfValues[i]);
                } else {
                    System.out.printf(templateOutputString, array[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printTriangularMatrix(double[][] array, String maxSize) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&", String.valueOf(PRECISION));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf(templateOutputString, array[i][j] + 0.0);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
