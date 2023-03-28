package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarousel {
    private int filledSize;
    static int[] elements;
    private boolean called;

    public DecrementingCarousel(int capacity) {
        elements = new int[capacity];
    }

    public boolean addElement(int element) {
        if (element <= 0 || elements.length == filledSize) {
            return false;
        }
        elements[filledSize++] = element;
        return true;
    }

    public CarouselRun run() {
        if (!called) {
            elements = Arrays.copyOf(elements, filledSize);
            called = true;
            return new CarouselRun();
        } else {
            return null;
        }
    }
}
