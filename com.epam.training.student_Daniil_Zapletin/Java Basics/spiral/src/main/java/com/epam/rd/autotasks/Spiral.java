package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] spiralMatrix = new int[rows][columns];
        int value = 1;
        int minColumn = 0;
        int maxColumn = columns-1;
        int minRow = 0;
        int maxRow = rows-1;

        outer:while (value <= rows*columns)
        {
            for (int i = minColumn; i <= maxColumn; i++)
            {
                if (value > rows*columns){
                    break outer;
                }
                spiralMatrix[minRow][i] = value;
                value++;
            }

            for (int i = minRow+1; i <= maxRow; i++)
            {
                if (value > rows*columns){
                    break outer;
                }
                spiralMatrix[i][maxColumn] = value;
                value++;
            }

            for (int i = maxColumn-1; i >= minColumn; i--)
            {
                if (value > rows*columns){
                    break outer;
                }
                spiralMatrix[maxRow][i] = value;
                value++;
            }

            for (int i = maxRow-1; i >= minRow+1; i--)
            {
                if (value > rows*columns){
                    break outer;
                }
                spiralMatrix[i][minColumn] = value;
                value++;
            }
            minColumn++;
            minRow++;
            maxColumn--;
            maxRow--;
        }
        return spiralMatrix;
    }
}
