package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    static int actionLimit;
    public DecrementingCarouselWithLimitedRun(int capacity, int actionLimit) {
        super(capacity);
        DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
    }

    @Override
    public boolean addElement(int element) {
        return super.addElement(element);
    }

    @Override
    public CarouselRun run() {
        if (!called) {
            called = true;
            return new LimitedCarouselRun();
        }
        return null;
    }
}
