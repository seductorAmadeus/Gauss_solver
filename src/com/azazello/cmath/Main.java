package com.azazello.cmath;


public class Main {

    private static InputType type = InputType.RANDOM_COEFFICIENT;
    private static Boolean dataEntered = false;
    private static Boolean actionWasSuccessfully = false;
    private static double[][] matrix;
    private static double[] vectorOfValues;
    private static Input input;
    private static Output output;
    private static int PRECISION = 2;

    public static void main(String[] args) {
        input = new Input(type);
        output = new Output();
        while (true) {
            output.showMainMenu(type);
            switch (input.getMenuItem()) {
                case 1: {
                    changeInputType();
                }
                break;
                case 2: {
                    enterNewData();
                }
                break;
                case 3: {
                    gaussMethod();
                }
                break;
                case 4: {
                    Runtime.getRuntime().exit(0);
                }
                break;
                default:
                    System.out.println("Re-enter menu item, please: ");
            }
        }
    }


    private static void allocateVectorOfValues() {
        vectorOfValues = new double[matrix[0].length];
        for (int i = 0; i < matrix[0].length - 1; i++) {
            vectorOfValues[i] = matrix[i][matrix[0].length - 1];
        }
    }

    private static void gaussMethod() {

        if (dataEntered == false) {
            System.out.println("The input data is not found, type the new data \n");

        } else {

            GaussMethod method = new GaussMethod(matrix[0].length - 1, matrix, vectorOfValues);
            System.out.println("\nTriangular matrix of system: ");
            output.fShowRealArray(method.getTriangularMatrix(), matrix.length, matrix[0].length - 1, String.valueOf(Math.round((method.getMaxStrLength()))), String.valueOf(PRECISION));
            System.out.println("Vector of solutions: ");
            output.fShowRealArray(method.getVectorOfSolutions(), matrix.length, String.valueOf(Math.round((method.getMaxStrLength()))), String.valueOf(PRECISION));
            System.out.println("Vector of residuals: ");
            output.fShowRealArray(method.getVectorOfResiduals(), matrix.length, String.valueOf(Math.round((method.getMaxStrLength()))), String.valueOf(PRECISION));
            dataEntered = false;
        }

    }

    private static void changeInputType() {
        while (true) {
            output.showSideMenu();
            switch (input.getMenuItem()) {
                case 1: {
                    type = InputType.CMD_INPUT;
                    actionWasSuccessfully = true;
                }
                break;
                case 2: {
                    type = InputType.FILE_INPUT;
                    actionWasSuccessfully = true;

                }
                break;
                case 3: {
                    type = InputType.RANDOM_COEFFICIENT;
                    actionWasSuccessfully = true;
                }
                break;
                default:
                    break;
            }
            if (actionWasSuccessfully) {
                input = new Input(type);
                actionWasSuccessfully = false;
                break;
            }

        }
    }

    private static double[][] enterNewData() {
        matrix = input.getMatrix();
        System.out.println("\nMatrix of system of equations: ");
        output.fShowRealArray(matrix, matrix.length, matrix[0].length, String.valueOf(Math.round((input.getMaxStrLength()))), String.valueOf(PRECISION));
        allocateVectorOfValues();
        dataEntered = true;
        return matrix;
    }

}
