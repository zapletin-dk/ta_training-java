package com.epam.rd.autotasks.arrays;
public class SumOfPrevious {
    public static boolean[] getSumCheckArray(int[] array){
        boolean []result = new boolean[array.length];
        result [0] = false;
        result [1] = false;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i-1] + array[i-2]){
                result[i] = true;
            } else{
                result[i] = false;
            }
        }
        //throw new UnsupportedOperationException();
        return result;
    }
}
