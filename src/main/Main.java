package main;

public class Main {
    static double[][] matrix = {{0, 1, 5, -4},
                             {1, 4, 3, -2},
                             {2, 7, 1, -2}};

    public static void main(String[] args) {
        int currentRow = 0;
        int pivotColumn = getPivotColumn(matrix);
        int currentColumn = pivotColumn;
        int nonZeroEntry = selectNoneZeroEntry(matrix, pivotColumn);
        createZeroBelowPivot(matrix, pivotColumn, 0);

        currentRow++;
        currentColumn++;
        double[][] subMatrix = getSubMatrix(matrix, currentRow, currentColumn);
        pivotColumn = getPivotColumn(subMatrix);
        nonZeroEntry = selectNoneZeroEntry(subMatrix, pivotColumn);
        createZeroBelowPivot(subMatrix, pivotColumn, 0);

        Display.printMatrix(subMatrix);
        System.out.println(currentRow);
    }

    /*
    Step 3: Use row replacement operations to create zeros in all positions below the
    pivot.
     */
    public static void createZeroBelowPivot(double[][] matrix, int pivotColumn, int currentRow) {
        for(int row = currentRow + 1; row < matrix.length; row++) {
            if(matrix[row][pivotColumn] != 0) {
                if(matrix[row][pivotColumn] >= matrix[currentRow][pivotColumn]) {
                    double scaler = Math.abs(matrix[row][pivotColumn] / matrix[currentRow][pivotColumn]);
                    RowOperations.row1MinusRow2(matrix, row, currentRow, scaler);
                    System.out.println("This ran");
                } else if(matrix[row][pivotColumn] < matrix[currentRow][pivotColumn]) {
                    double scaler = Math.abs(matrix[row][pivotColumn] / matrix[currentRow][pivotColumn]);
                    RowOperations.row1PlusRow2(matrix, row, currentRow, scaler);
                    System.out.println("This ran");
                }
            }
        }
    }

    /*
    Step 2: Select a nonzero entry in the pivot column as a pivot. If necessary,
    interchange rows to move this entry into the pivot position.
     */
    public static int selectNoneZeroEntry(double[][] matrix, int pivotColumn) {
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][pivotColumn] != 0) {
                if(row != 0) {
                    // if the its not the top most row, interchange it with the top most row
                    RowOperations.interchange(matrix, 0, row);
                }
                return (int)matrix[0][pivotColumn];
            }
        }
        return 0;
    }

    /*
    Step 1: Begin with the leftmost nonzero column. This is a pivot column. The pivot
    position is at the top.
     */
    public static int getPivotColumn(double[][] matrix) {
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

    public static double[][] getSubMatrix(double[][] matrix, int row, int col) {
        double[][] subArray = new double[matrix.length - row][matrix[0].length - col];

        for(int r = 0; r < subArray.length; r++) {
            for(int c = 0; c < subArray[0].length; c++) {
                subArray[r][c] = matrix[r + row][c + col];
            }
        }

        return subArray;
    }
}
