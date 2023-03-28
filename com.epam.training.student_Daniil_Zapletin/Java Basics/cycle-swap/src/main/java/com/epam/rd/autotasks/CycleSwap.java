package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        int[] temp = new int[array.length];
        if (array.length >0){
            temp[0] = array[array.length - 1];
            if (array.length > 1){
                System.arraycopy(array, 0, temp, 1, (array.length-1));
            }
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length > 0) {
            int[] temp = new int[array.length];
            int[] left = new int[array.length - shift];
            int[] right = new int[shift];
            if (shift <= array.length) {
                System.arraycopy(array, 0, left, 0, array.length - shift);
                System.arraycopy(array, array.length - shift, right, 0, shift);
                System.arraycopy(right, 0, temp, 0, right.length);
                System.arraycopy(left, 0, temp, right.length, left.length);
                System.arraycopy(temp, 0, array, 0, temp.length);
            }
        }
    }
}

