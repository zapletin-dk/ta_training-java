package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int row = matrix[0].length;
        int column = matrix.length;
        int[][] transposedMatrix = new int[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");

        int[][] matrix = {
                {1, 2, 3},
                {7, -13, 4} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
