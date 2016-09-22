package com.azazello.cmath;

public class Output {

    public static void fShowRealArray(double[] array, int q, String maxSize, String precision) {
        String str = "%#.&f";
        str = str.replace("#", maxSize).replace("&", precision);
        for (int i = 0; i < q; i++) {
            System.out.printf(str, array[i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void showMainMenu(InputType type) {
        System.out.println("Input mode = " +
                type.getName() + "\n" +
                "1. Change input type:\n" +
                "2. Enter new data\n" +
                "3. Run Gauss method\n" +
                "4. Exit\n" +
                "Enter menu item:\n");

    }

    public static void showSideMenu() {
        System.out.println("1. Input from the command line \n" +
                "2. Input from the (txt) file \n" +
                "3. Fill the matrix with random coefficients \n" +
                "Enter menu item:\n");
    }

    public static void fShowRealArray(double[][] array, int q, int n, String maxSize, String precision) {
        String str = "%#.&f";
        str = str.replace("#", maxSize).replace("&", precision);
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(str, array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
