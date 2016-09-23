package com.amadeus.cmath;


public class Main {

    private static InputType type = InputType.RANDOM_COEFFICIENT;
    private static Boolean dataEntered = false;
    private static Boolean actionWasSuccessfully = false;
    private static double[][] matrix;
    private static double[] vectorOfValues;
    private static Input input;
    private static MatrixPrinter matrixPrinter;

    public static void main(String[] args) {
        input = new Input(type);
        matrixPrinter = new MatrixPrinter();
        while (true) {
            matrixPrinter.printMainMenu(type);
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

    private static void gaussMethod() {

        if (!dataEntered) {
            System.out.println("The input data is not found, type the new data \n");

        } else {

            GaussMethod method = new GaussMethod(matrix[0].length - 1, matrix, vectorOfValues);
            System.out.println("\nTriangular matrix of system: ");

            matrixPrinter.printTriangularMatrix(method.getTriangularMatrix(), String.valueOf(Math.round(method.getMaxStrLength())));
            System.out.println("Vector of solutions: ");
            matrixPrinter.printVector(method.getVectorOfSolutions(), String.valueOf(Math.round((method.getMaxStrLength()))) );
            System.out.println("Vector of residuals: ");
            matrixPrinter.printVector(method.getVectorOfResiduals(), String.valueOf(Math.round((method.getMaxStrLength()))));
            dataEntered = false;
        }

    }

    private static void changeInputType() {
        while (true) {
            matrixPrinter.printSideMenu();
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

    private static void enterNewData() {
        input.getMatrix();

        System.out.println("\nAugmented matrix of the system: ");
        matrixPrinter.printMatrix(InputData.getMatrix(), String.valueOf(Math.round((input.getMaxStrLength()))));

        dataEntered = true;

    }

}
