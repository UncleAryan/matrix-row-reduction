package main;

public class RowOperations {
    // below are all row operations to perform on augmented matrices
    public static void interchange(double[][] matrix, int row1, int row2) {
        double[] tempRow = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tempRow;
    }

    public static void row1PlusRow2(double[][] matrix, int row1, int row2, double scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row1][i] += matrix[row2][i] * scaler;
        }
    }

    public static void row1MinusRow2(double[][] matrix, int row1, int row2, double scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row1][i] -= matrix[row2][i] * scaler;
        }
    }

    public static void scaleRow(double[][] matrix, int row, double scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] *= matrix[row][i] * scaler;
        }
    }
}
