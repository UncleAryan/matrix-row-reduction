package main;

public class Main {
    static int[][] matrix = {{0, 1, 5, -4},
                             {1, 4, 3, -2},
                             {2, 7, 1, -2}};

    static int[][] matrix1 = {{0, 1, 5, -4},
                             {0, 4, 3, -2},
                             {0, 7, 1, -2}};

    public static void main(String[] args) {
        int pivot = getRowReducedForm(matrix);
        System.out.println(pivot);
    }

    public static int getRowReducedForm(int[][] matrix) {
        int[][] newMatrix = matrix;
        int pivotColumn;
        int currentColumn = getPivotColumn(newMatrix);

        return currentColumn;
    }

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

    public static int getLeftMostNonZeroColumn(int[][] matrix) {
        int pivot = 0;
        int currentColumn = 0;

        // get leftmost non-zero column
        while(pivot == 0) {
            for(int i = 0; i < matrix.length; i++) {
                if(matrix[i][currentColumn] != 0) {
                    return matrix[i][currentColumn];
                }
            }
            currentColumn++;
        }

        return pivot;
    }
}
