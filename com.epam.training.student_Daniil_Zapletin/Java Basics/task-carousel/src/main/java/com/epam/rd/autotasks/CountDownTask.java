package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private int initialValue;
    public CountDownTask(int value) {
        initialValue = Math.max(value, 0);
        if (value == 0){ isFinished(); }
    }

    public int getValue() { return initialValue; }


    @Override
    public void execute() {
        if (initialValue > 0) {
            initialValue--;
        } else {
            initialValue = 0;
        }
    }

    @Override
    public boolean isFinished() { return initialValue == 0; }
}
