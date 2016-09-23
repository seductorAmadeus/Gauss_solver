package com.amadeus.cmath;

import java.io.*;
import java.util.*;

public class Input {
    private InputType type;
    private int n; // count of rows
    private Scanner in, menuItemIn;
    private double[][] matrix;
    private Double[] subMatrix;
    private Boolean actionWasSuccessfully = false;
    private Random random;
    private InputData inputData;
    private int maxStrLength = 0;

    private static String filePath = "Please, enter the full (txt) file path: \n",
            filePathExp = "File not found, repeat, please \n",
            inputLine = "Enter the line: \n",
            inputLineFormatExp = "Format error-line, retype the line: \n",
            arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, retype the line \n",
            inputLineSomeExp = "Error reading line, retype the line:  \n",
            inputDimensionMatrix = "Enter dimension of the matrix: \n",
            inputValueFormatExp = "Input error, re-enter the positive (integer) dimension of the matrix: \n";

    Input(InputType inputType) {

        inputData = new InputData();

        switch (inputType) {
            case FILE_INPUT: {
                type = InputType.FILE_INPUT;
                inputLine = "";
                inputLineFormatExp = "Format error-line, change the line in the file. \n";
                arrayIndexOutOfBoundsExp = "Invalid number of elements in the line, change the line in the file. \n";
                inputLineSomeExp = "Error reading line, change the line in the file.  \n";
                inputDimensionMatrix = "";
                inputValueFormatExp = "Input error, change the line in the file. \n ";

               /* while (true) {
                    System.out.print(filePath);
                    try {
                        Scanner filepathIn = new Scanner(System.in);
                        in = new Scanner(new File(filepathIn.nextLine()));
                        break;
                    } catch (FileNotFoundException exp) {
                        System.out.print(filePathExp);
                    }
                }*/
                try {
                    in = new Scanner(new File("C:\\Users\\admin\\Desktop\\LabsCMath\\example.txt")); // убрать
                } catch (FileNotFoundException exp) {
                    System.out.print(filePathExp);
                }
            }
            break;
            case RANDOM_COEFFICIENT: {
                type = InputType.RANDOM_COEFFICIENT;
                in = new Scanner(System.in);
                random = new Random();
            }
            break;
            case CMD_INPUT: {
                type = InputType.CMD_INPUT;
                in = new Scanner(System.in);
            }
            break;
        }
    }

    private Double[] getStringOfRandomValues() {

        subMatrix = new Double[n + 1];

        for (int i = 0; i < subMatrix.length; i++) {

            subMatrix[i] = random.nextDouble() * 100;
            if (String.valueOf(subMatrix[i]).length() > maxStrLength) {
                maxStrLength = String.valueOf(subMatrix[i]).length();
            }
        }

        return subMatrix;
    }

    public int getMaxStrLength() {
        return maxStrLength;
    }

    public Integer getMenuItem() {
        Integer menuItem = null;
        while (true) {
            try {
                menuItemIn = new Scanner(System.in);
                menuItem = menuItemIn.nextInt();
                actionWasSuccessfully = true;
            } catch (NumberFormatException exp) {
                System.out.println("Format error, re-enter menu item, please: ");
            } catch (Exception exp) {
                System.out.println("Unknown error, please try enter integer value:  ");
            }
            if (actionWasSuccessfully) {
                actionWasSuccessfully = false;
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
                System.out.print(inputLine);
                someString = in.nextLine();
                resultString = someString.split(" ");
                subMatrix = new Double[n + 1];
                for (int k = 0; k < resultString.length; k++) {
                    if (resultString[k].length() == 0) {
                        continue;
                    } else {
                        if (resultString[k].length() > maxStrLength) {
                            maxStrLength = resultString[k].length();
                        }
                    }
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

    public double[][] getMatrix() {
        int i, j;

        while (true) {

            try {

                System.out.print(inputDimensionMatrix);

                n = Integer.valueOf(in.nextLine());

                if ((n <= 1) || (n > 20)) {
                    throw new NumberFormatException();
                }

                inputData.setDimensionOfMatrix(n);

                break;



            } catch (NumberFormatException exp) {
                System.out.print(inputValueFormatExp);
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

                inputData.fillMatrix(i, j, subMatrix[j]);
              //  matrix[i][j] = subMatrix[j];
            }
        }

        return matrix;
    }
}
