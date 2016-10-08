package com.amadeus.cmath;

public class Main {

    private static InputType type = InputType.FILE_INPUT;
    private static Boolean dataEntered = false;
    private static Boolean calculationWasSuccessfully = false;
    private static Boolean actionWasSuccessfully = false;
    private static Input input;
    private static MatrixPrinter matrixPrinter;
    private static int maxStrLength = 0;

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
                    if (calculationWasSuccessfully) {
                        Runtime.getRuntime().exit(0);
                    }
                }
                break;
                case 4: {
                    Runtime.getRuntime().exit(0);
                }
                break;
                default:
                    System.out.println("Re-enter menu item, please\n");
            }
        }
    }

    private static void runGaussSolver() {

        if (!dataEntered) {
            System.out.println("The input data is not found; please, enter new data \n");

        } else {

            GaussSolver.runGaussMethod(InputData.getDimensionOfMatrix(), InputData.getMatrix(), InputData.getVectorOfValues(), OutputData.getVectorOfSolutions());
            GaussSolver.getVectorOfResiduals(OutputData.getVectorOfResiduals(), InputData.getOriginalVectorOfValues(), InputData.getOriginalMatrix(), OutputData.getVectorOfSolutions());

            System.out.println("\nTriangular matrix of system: ");
            matrixPrinter.printTriangularMatrix(OutputData.getTriangularMatrix(), String.valueOf(Math.round(getMaxStrLength(OutputData.getTriangularMatrix()))));
            System.out.println("Determinant: " + OutputData.getDeterminant());
            System.out.println("\nVector of solutions: ");
            matrixPrinter.printVector(OutputData.getVectorOfSolutions(), String.valueOf(Math.round((getMaxStrLength(OutputData.getTriangularMatrix())))), "f");
            System.out.println("Vector of residuals: ");
            matrixPrinter.printVector(OutputData.getVectorOfResiduals(), String.valueOf(Math.round((getMaxStrLength(OutputData.getTriangularMatrix())))), "e");
            calculationWasSuccessfully = true;
            dataEntered = false;
        }
    }

    private static int getMaxStrLength(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (String.valueOf(matrix[i][j]).length() > maxStrLength) {
                    maxStrLength = String.valueOf(matrix[i][j]).length();
                }
            }
        }
        return maxStrLength;
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
                    System.out.println("Re-enter menu item, please\n");
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
        matrixPrinter.printMatrix(InputData.getMatrix(), InputData.getVectorOfValues(), String.valueOf(Math.round((getMaxStrLength(InputData.getOriginalMatrix())*1.8))));
        dataEntered = true;
    }
}
