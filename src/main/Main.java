package main;

public class Main {
    static int[][] matrix = {{0, 1, 5, -4},
                             {1, 4, 3, -2},
                             {2, 7, 1, -2}};

    public static void main(String[] args) {
        //int pivotColumn = getPivotColumn(matrix);
        //int nonZeroEntry = getNonZeroEntry(matrix, pivotColumn);

        row1PlusRow2(matrix, 0, 1, 2);

        printMatrix(matrix);
        //System.out.println("Nonzero Pivot Entry: " + nonZeroEntry);
    }

    /*
    Step 3: Use row replacement operations to create zeros in all positions below the
    pivot.
     */
    public static void createZeroBelowPivot(int[][] matrix, int pivot) {

    }

    /*
    Step 2: Select a nonzero entry in the pivot column as a pivot. If necessary,
    interchange rows to move this entry into the pivot position.
     */
    public static int getNonZeroEntry(int[][] matrix, int pivotColumn) {
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][pivotColumn] != 0) {
                if(row != 0) {
                    // if the its not the top most row, interchange it with the top most row
                    interchange(matrix, 0, row);
                }
                return matrix[0][pivotColumn];
            }
        }
        return 0;
    }

    /*
    Step 1: Begin with the leftmost nonzero column. This is a pivot column. The pivot
    position is at the top.
     */
    public static int getPivotColumn(int[][] matrix) {
        // leftmost nonzero column
        int currentColumn = 0;

        while(currentColumn != matrix[0].length - 1) {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][currentColumn] != 0) {
                    return currentColumn; // a nonzero column has been found
                }
            }
            currentColumn++;
        }

        return -1; // a nonzero column was not found
    }

    // below are all row operations to perform on augmented matrices
    public static void interchange(int matrix[][], int row1, int row2) {
        int[] tempRow = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tempRow;
    }

    public static void row1PlusRow2(int[][] matrix, int row1, int row2, int scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row1][i] += matrix[row2][i] * scaler;
        }
    }

    public static void row1MinusRow2(int[][] matrix, int row1, int row2, int scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row1][i] -= matrix[row2][i] * scaler;
        }
    }

    public static void scaleRow(int[][] matrix, int row, int scaler) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] *= matrix[row][i] * scaler;
        }
    }

    // method to print an matrix (2d array) for debugging purposes
    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
