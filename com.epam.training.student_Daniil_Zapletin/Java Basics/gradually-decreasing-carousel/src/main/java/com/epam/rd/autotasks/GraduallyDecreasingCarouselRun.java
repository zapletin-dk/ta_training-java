package com.epam.rd.autotasks;

public class GraduallyDecreasingCarouselRun extends CarouselRun {
    int decrement = 1;
    @Override
    public int next() {
        int beforeDecreasing;
        if (!isFinished()) {
            beforeDecreasing = array[position];
            array[position] -= decrement;
            do {
                position++;
                if (position == array.length) {
                    decrement++;
                    position = 0;
                }
            } while ((array[position] <= 0) && !isFinished());
        } else { return -1; }

        return beforeDecreasing;
    }
}