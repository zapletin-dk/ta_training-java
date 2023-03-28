package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {
    public static int sum(int[] array){
        int sumOfArrayNumbers = 0;
        if (array == null){
            return sumOfArrayNumbers;
        }
        for (int number : array) {
            if (number %2 == 0){
                sumOfArrayNumbers += number;
            }
        }
        return sumOfArrayNumbers;
    }
}
