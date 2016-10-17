package com.amadeus.cmath;

public class Main {

    private static InputType type = InputType.FILE_INPUT;
    private static Input input = new Input(InputType.CMD_INPUT);
    private static Boolean dataEntered = false;
    private static Boolean calculationWasSuccessfully = false;

    public static void main(String[] args) {
        while (true) {
            MatrixPrinter.printMainMenu(type);
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
            GaussSolver.solve(InputData.dataUnpack());
            MatrixPrinter.printOutputData(OutputData.dataUnpack());
            calculationWasSuccessfully = true;
            dataEntered = false;
        }
    }

    private static void changeInputType() {
        Boolean actionWasSuccessfully = false;
        while (true) {
            MatrixPrinter.printSideMenu();
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
                dataEntered = false;
                break;
            }
        }
    }

    private static void enterNewData() {
        input = new Input(type);
        input.getMatrix();
        MatrixPrinter.printInputData(InputData.dataUnpack());
        dataEntered = true;
    }
}
