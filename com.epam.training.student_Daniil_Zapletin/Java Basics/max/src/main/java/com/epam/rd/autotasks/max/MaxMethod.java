package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int maxValue = values[0];
        for (int nextValue : values) {
            if (nextValue > maxValue){
                maxValue = nextValue;
            }
        }
        return maxValue;
    }
}


