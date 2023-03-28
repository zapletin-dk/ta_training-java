package com.epam.rd.autotasks;

public class LimitedCarouselRun extends CarouselRun{
    int amountOfRuns = DecrementingCarouselWithLimitedRun.actionLimit +1;
    @Override
    public int next() {
        int stepCounter = 0;
        amountOfRuns--;
        while (stepCounter < array.length && array[position %= array.length] <= 0) {
            position++;
            stepCounter++;
        }
        if (stepCounter == array.length || amountOfRuns <= 0) return -1;
        return array[position++]--;
    }

    @Override
    public boolean isFinished() {
        int sumOfArray = 0;
        for (int number: array){
            sumOfArray += number;
        }
        return sumOfArray == 0 || amountOfRuns <= 1;
    }
}
