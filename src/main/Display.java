package main;

public class Display {
    // method to print an matrix (2d array) for debugging purposes
    public static void printMatrix(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 0) {
                    System.out.print((int)matrix[i][j] + " ");
                } else {
                    System.out.print(" " + (int)matrix[i][j] + " ");
                }

            }
            System.out.println();
        }
    }
}
