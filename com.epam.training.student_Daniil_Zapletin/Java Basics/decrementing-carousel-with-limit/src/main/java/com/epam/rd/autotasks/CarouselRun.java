package com.epam.rd.autotasks;

public class CarouselRun {
    int position = 0;
    int[] array = DecrementingCarousel.elements;
    public int next() {
        int stepCounter = 0;
        while (stepCounter < array.length && array[position %= array.length] <= 0) {
            position++;
            stepCounter++;
        }
        if (stepCounter == array.length ) return -1;
        return array[position++] --;
    }

    public boolean isFinished() {
        for (int number : array) {
            if (number > 0) return false;
        }
        return true;
    }

}