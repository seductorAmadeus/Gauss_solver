package com.amadeus.cmath;

public class Main {

    private static InputType type = InputType.FILE_INPUT;
    private static Input input = new Input(InputType.CMD_INPUT);
    private static Boolean dataEntered = false;
    private static Boolean calculationWasSuccessfully = false;

    public static void main(String[] args) {
        InputData inputData = null;
        while (true) {
            MatrixPrinter.printMainMenu(type);
            switch (input.getMenuItem()) {
                case 1: {
                    changeInputType();
                }
                break;
                case 2: {
                    inputData = getNewData();
                }
                break;
                case 3: {
                    runGaussSolver(inputData);
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

    private static void runGaussSolver(InputData inputData) {
        if (inputData == null || !dataEntered) {
            System.out.println("The input data is not found; please, enter new data \n");

        } else {
            OutputData outputData;
            outputData = GaussSolver.solve(inputData);
            MatrixPrinter.printOutputData(outputData);
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


    private static InputData getNewData() {
        input = new Input(type);
        InputData inputData = input.getInputData();
        MatrixPrinter.printInputData(inputData);
        dataEntered = true;
        return inputData;
    }
}
