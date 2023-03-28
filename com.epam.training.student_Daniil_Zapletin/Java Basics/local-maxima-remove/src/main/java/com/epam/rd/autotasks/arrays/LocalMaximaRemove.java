package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static int[] removeLocalMaxima(int[] array){
        int[] copyOfArray = new int[array.length];
        int stepsCounter = 0;
        if (array[0] <= array[1]){
            copyOfArray[stepsCounter] = array[0];
            stepsCounter++;
        }
        for (int i = 1; i < array.length-1; i++) {
            if (array[i-1] >= array[i] || array[i] <= array[i+1]){
                copyOfArray[stepsCounter] = array[i];
                stepsCounter++;
            }
        }
        if (array[array.length-1] <= array[array.length-2]){
            copyOfArray[stepsCounter] = array[array.length-1];
            stepsCounter++;
        }
        return Arrays.copyOf(copyOfArray,stepsCounter);
    }
}
