package com.amadeus.cmath;

public class Main {

    private static InputType type = InputType.FILE_INPUT;
    private static Boolean dataEntered = false;
    private static Boolean actionWasSuccessfully = false;
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
                    runGaussSolver();
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

    private static void runGaussSolver() {

        if (!dataEntered) {
            System.out.println("The input data is not found, type the new data \n");

        } else {
            GaussSolver.runGaussMethod(InputData.getDimensionOfMatrix(),InputData.getMatrix(), InputData.getVectorOfValues());

            GaussSolver.getVectorOfResiduals(OutputData.getVectorOfResiduals(), InputData.getOriginalVectorOfValues(), InputData.getOriginalMatrix(), OutputData.getVectorOfSolutions());

            System.out.println("\nTriangular matrix of system: ");
            matrixPrinter.printTriangularMatrix(OutputData.getTriangularMatrix(), String.valueOf(Math.round(GaussSolver.getMaxStrLength())));
            System.out.println("Vector of solutions: ");
            matrixPrinter.printVector(OutputData.getVectorOfSolutions(), String.valueOf(Math.round((GaussSolver.getMaxStrLength()))), "f");
            System.out.println("Vector of residuals: ");
            matrixPrinter.printVector(OutputData.getVectorOfResiduals(), String.valueOf(Math.round((GaussSolver.getMaxStrLength()))), "e");

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
        matrixPrinter.printMatrix(InputData.getMatrix(), InputData.getVectorOfValues(), String.valueOf(Math.round((input.getMaxStrLength()))));
        dataEntered = true;
    }
}
