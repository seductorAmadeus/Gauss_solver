package com.amadeus.cmath;

import java.io.*;
import java.util.*;

public class Input {

    private String inputLineMessage, inputLineFormatExp, arrayIndexOutOfBoundsExp, inputDimensionFormatExp, inputDimensionMatrixMessage, inputLineSomeExp;
    private InputType inputType;
    private Scanner in;

    Input(InputType inputType) {

        switch (inputType) {
            case FILE_INPUT: {
                this.inputType = InputType.FILE_INPUT;
                inputLineMessage = "";
                String filePathMessage = "Enter full (.txt) file path: \n";
                String filePathExp = "File not found, re-enter (.txt) file path: \n";
                inputLineFormatExp = "Format error-line, change the line in the file: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, change the line in the file: \n";
                inputLineSomeExp = "Error reading line, change the line in the file:  \n";
                inputDimensionMatrixMessage = "";
                inputDimensionFormatExp = "Input error, change dimension of the matrix in a file on a positive integer (1 < n <= 20): \n";
                while (true) {
                    System.out.print(filePathMessage);
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
                this.inputType = InputType.RANDOM_COEFFICIENT;
                inputLineMessage = "Enter the line";
                inputLineFormatExp = "Format error-line, re-enter the line: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, re-enter the line \n";
                inputLineSomeExp = "Error reading line, re-enter the line:  \n";
                inputDimensionMatrixMessage = "Enter dimension of the matrix: \n";
                inputDimensionFormatExp = "Input error, re-enter positive integer dimension of the matrix (1 < n <= 20)\n";
                in = new Scanner(System.in);
            }
            break;
            case CMD_INPUT: {
                this.inputType = InputType.CMD_INPUT;
                inputLineMessage = "Enter the line";
                inputLineFormatExp = "Format error-line, re-enter the line: \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, re-enter the line \n";
                inputLineSomeExp = "Error reading line, re-enter the line:  \n";
                inputDimensionMatrixMessage = "Enter dimension of the matrix: \n";
                inputDimensionFormatExp = "Input error, re-enter positive integer dimension of the matrix (1 < n <= 20)\n";
                in = new Scanner(System.in);
            }
            break;
        }
    }

    private Double[] getVectorOfRandomValues(int n) {
        Double[] subMatrix = new Double[n + 1];
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
                System.out.println("Format error, re-enter menu item (1, 2, 3 or 4): ");
            } catch (Exception exp) {
                System.out.println("Format error, re-enter menu item (1, 2, 3 or 4): ");
            }
            if (actionWasSuccessfully) {
                break;
            }
        }
        return menuItem;
    }

    private Double[] getVector(int n) {
        Double[] subMatrix;
        String[] resultString;
        int i = 0;
        while (true) {
            try {
                if (inputLineMessage.length() != 0) {
                    System.out.print(inputLineMessage + ", containing " + (n + 1) + " argument the augmented matrix of the system:\n");
                }
                resultString = in.nextLine().split("\\s+");
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
                if (inputType == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } catch (ArrayIndexOutOfBoundsException exp) {
                System.out.print(arrayIndexOutOfBoundsExp);
                if (inputType == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } catch (Exception exp) {
                System.out.print(inputLineSomeExp);
                if (inputType == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            } finally {
                i = 0;
            }
        }
        return subMatrix;
    }

    public InputData getInputData() {
        Double[] subMatrix;
        int i, j, n;
        double[][] matrix;
        double[] vectorOfValues;
        while (true) {
            try {
                System.out.print(inputDimensionMatrixMessage);
                n = Integer.valueOf(in.nextLine().replaceAll("[\\s]{2,}", ""));
                if ((n <= 1) || (n > 20)) {
                    throw new NumberFormatException();
                }
                matrix = new double[n][n];
                vectorOfValues = new double[n];
                break;
            } catch (NumberFormatException exp) {
                System.out.print(inputDimensionFormatExp);
                if (inputType == InputType.FILE_INPUT) {
                    Runtime.getRuntime().exit(1);
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (inputType == InputType.RANDOM_COEFFICIENT) {
                subMatrix = getVectorOfRandomValues(n);
            } else {
                subMatrix = getVector(n);
            }
            for (j = 0; j < n + 1; j++) {
                if (j + 1 >= n + 1) {
                    vectorOfValues[i] = subMatrix[j];
                } else {
                    matrix[i][j] = subMatrix[j];
                }
            }
        }
        return new InputData(matrix, vectorOfValues);
    }
}
