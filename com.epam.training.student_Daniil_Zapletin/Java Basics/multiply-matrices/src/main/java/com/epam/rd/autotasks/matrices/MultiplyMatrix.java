package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int [][]result = new int[matrix1.length][matrix2[0].length];
        for (int i=0; i< matrix1.length; i++) {
            for (int j=0; j< matrix2[0].length; j++) {
                for (int k=0; k< matrix2.length; k++) {

                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6} };

        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
