package com.amadeus.cmath;

public class MatrixPrinter {

    private static int PRECISION = 3;

    private static void printVector(double[] array, String maxSize, String format) {
        String templateOutputString = "%#.&f";
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&", String.valueOf(PRECISION)).replace("f", format);
        for (int i = 0; i < array.length; i++) {
            System.out.printf(templateOutputString, array[i] + 0.0);
            System.out.println();
        }
        System.out.println();
    }

    public static void printInputData(InputData inputData) {
        String maxNumSize = String.valueOf(inputData.getMaxNumSize() * PRECISION);
        System.out.println("\nAugmented matrix of the system: ");
        printMatrix(inputData.getMatrix(), inputData.getVectorOfValues(), maxNumSize);
    }

    public static void printOutputData(OutputData outputData) {
        String maxNumSize = String.valueOf(outputData.getMaxNumSize());
        System.out.println("\nTriangular matrix of system: ");
        printTriangularMatrix(outputData.getTriangularMatrix(), maxNumSize);
        System.out.println("Determinant: " + outputData.getDeterminant());
        System.out.println("\nVector of solutions: ");
        printVector(outputData.getVectorOfSolutions(), maxNumSize, "f");
        System.out.println("Vector of residuals: ");
        printVector(outputData.getVectorOfResiduals(), maxNumSize, "e");
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
        String templateOutputString = "%#.&f";
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
        String templateOutputString = "%#.&f";
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
