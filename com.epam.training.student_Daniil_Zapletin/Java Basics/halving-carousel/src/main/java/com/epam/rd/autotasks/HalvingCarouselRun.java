package com.epam.rd.autotasks;

public class HalvingCarouselRun extends CarouselRun {

    @Override
    public int next() {
        int count = 0;
        while (count < array.length && array[position %= array.length] <= 0) {
            position++;
            count++;
        }
        if (count == array.length) return -1;
        return postDivision();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    public int postDivision () {
        int temp = array[position];
        array[position++] /=2;
        return temp;
    }

}