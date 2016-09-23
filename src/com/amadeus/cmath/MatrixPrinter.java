package com.amadeus.cmath;

public class MatrixPrinter {

    private int PRECISION = 4;
    private String templateOutputString = "%#.&f";

    public  void printVector(double[] array, String maxSize) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&", String.valueOf(PRECISION));
        for (int i = 0; i < array.length; i++) {
            System.out.printf(templateOutputString, array[i]);
            System.out.println();
        }
        System.out.println();
    }

    public  void printMainMenu(InputType type) {
        System.out.println("Input mode = " +
                type.getName() + "\n" +
                "1. Change input type:\n" +
                "2. Enter new data\n" +
                "3. Run Gauss method\n" +
                "4. Exit\n" +
                "Enter menu item:\n");

    }

    public  void printSideMenu() {
        System.out.println("1. Input from the command line \n" +
                "2. Input from the (txt) file \n" +
                "3. Fill the matrix with random coefficients \n" +
                "Enter menu item:\n");
    }

    public  void printMatrix(double[][] array, String maxSize) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&",String.valueOf(PRECISION));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf(templateOutputString, array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public  void printTriangularMatrix(double[][] array, String maxSize) {
        templateOutputString = templateOutputString.replace("#", maxSize).replace("&",String.valueOf(PRECISION));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length-1; j++) {
                System.out.printf(templateOutputString, array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
