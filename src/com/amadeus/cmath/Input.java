package com.amadeus.cmath;

import java.io.*;
import java.util.*;

public class Input {

    private InputType type;
    private int n;
    private Scanner in;
    private Double[] subMatrix;
    public static double[] vectorOfValues;
    public static double[][] matrix;
    private static String filePath, filePathExp, inputLine, inputLineFormatExp, arrayIndexOutOfBoundsExp, inputLineSomeExp, inputDimensionMatrix, inputDimensionFormatExp;

    Input(InputType inputType) {

        switch (inputType) {
            case FILE_INPUT: {
                type = InputType.FILE_INPUT;
                inputLine = "";
                filePath = "Please, enter the full (txt) file path: \n";
                filePathExp = "File not found, repeat, please: \n";
                inputLineFormatExp = "Format error-line, change the line in the file: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, change the line in the file: \n";
                inputLineSomeExp = "Error reading line, change the line in the file:  \n";
                inputDimensionMatrix = "";
                inputDimensionFormatExp = "Input error, change integer dimension (1 < n <= 20) of the matrix in the file: \n";

                while (true) {
                    System.out.print(filePath);
                    try {
                        Scanner filepathIn = new Scanner(System.in);
                        in = new Scanner(new File(filepathIn.nextLine()));
                        break;
                    } catch (FileNotFoundException exp) {
                        System.out.print(filePathExp);
                    }
                }
            }
            break;
            case RANDOM_COEFFICIENT: {
                type = InputType.RANDOM_COEFFICIENT;
                inputLine = "Enter the line";
                inputLineFormatExp = "Format error-line, retype the line: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, retype the line \n";
                inputLineSomeExp = "Error reading line, retype the line:  \n";
                inputDimensionMatrix = "Enter dimension of the matrix: \n";
                inputDimensionFormatExp = "Input error, re-enter the positive integer dimension (1 < n <= 20) of the matrix \n";
                in = new Scanner(System.in);
            }
            break;
            case CMD_INPUT: {
                type = InputType.CMD_INPUT;
                inputLine = "Enter the line";
                inputLineFormatExp = "Format error-line, retype the line: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, retype the line \n";
                inputLineSomeExp = "Error reading line, retype the line:  \n";
                inputDimensionMatrix = "Enter dimension of the matrix: \n";
                inputDimensionFormatExp = "Input error, re-enter the positive integer dimension (1 < n <= 20) of the matrix \n";
                in = new Scanner(System.in);
            }
            break;
        }
    }

    private Double[] getStringOfRandomValues() {
        subMatrix = new Double[n + 1];
        for (int i = 0; i < subMatrix.length; i++) {
            subMatrix[i] = Math.random() * 100;
        }
        return subMatrix;
    }

    public Integer getMenuItem() {
        Boolean actionWasSuccessfully = false;
        Integer menuItem = null;
        while (true) {
            try {
                Scanner menuItemIn = new Scanner(System.in);
                menuItem = menuItemIn.nextInt();
                actionWasSuccessfully = true;
            } catch (NumberFormatException exp) {
                System.out.println("Format error, re-enter menu item, please: ");
            } catch (Exception exp) {
                System.out.println("Unknown error, please try enter integer value:  ");
            }
            if (actionWasSuccessfully) {
                break;
            }
        }
        return menuItem;
    }

    private Double[] getStringValues() {
        String someString, resultString[];
        int i = 0;
        while (true) {
            try {
                if (inputLine.length() != 0) {
                    System.out.print(inputLine + ", containing " + (n + 1) + " argument the augmented matrix of the system:\n");
                }
                someString = in.nextLine();
                resultString = someString.split(" ");
                subMatrix = new Double[n + 1];
                for (int k = 0; k < resultString.length; k++) {
                    subMatrix[i] = Double.valueOf(resultString[k]);
                    i++;
                }
                if (subMatrix[n] == null) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                break;
            } catch (NumberFormatException exp) {
                System.out.print(inputLineFormatExp);
                if (type == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } catch (ArrayIndexOutOfBoundsException exp) {
                System.out.print(arrayIndexOutOfBoundsExp);
                if (type == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } catch (Exception exp) {
                System.out.print(inputLineSomeExp);
                if (type == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } finally {
                i = 0;
            }
        }
        return subMatrix;
    }

    public void getMatrix() {
        int i, j;
        while (true) {

            try {
                System.out.print(inputDimensionMatrix);
                n = Integer.valueOf(in.nextLine());
                if ((n <= 1) || (n > 20)) {
                    throw new NumberFormatException();
                }
                matrix = new double[n][n];
                vectorOfValues = new double[n];
                break;
            } catch (NumberFormatException exp) {
                System.out.print(inputDimensionFormatExp);
                if (type == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (type == InputType.RANDOM_COEFFICIENT) {
                getStringOfRandomValues();
            } else {
                getStringValues();
            }
            for (j = 0; j < n + 1; j++) {
                if (j + 1 >= n + 1) {
                    vectorOfValues[i] = subMatrix[j];
                } else {
                    matrix[i][j] = subMatrix[j];
                }
            }
        }
        InputData.dataPack(matrix, vectorOfValues);
    }
}
