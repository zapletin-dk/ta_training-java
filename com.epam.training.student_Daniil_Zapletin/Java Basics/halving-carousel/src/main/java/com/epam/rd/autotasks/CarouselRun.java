package com.epam.rd.autotasks;

public class CarouselRun {
    int position = 0;
    int[] array = DecrementingCarousel.elements;
    public int next() {
        int count = 0;
        while (count < array.length && array[position %= array.length] <= 0) {
            position++;
            count++;
        }
        if (count == array.length) return -1;
        return array[position++] --;
    }

    public boolean isFinished() {
        for (int element: array) {
            if (element > 0) return false;
        }
        return true;
    }

}