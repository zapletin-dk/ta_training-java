package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends  DecrementingCarousel{
    public GraduallyDecreasingCarousel(int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if (!called) {
            called = true;
            return new GraduallyDecreasingCarouselRun();
        }
        return null;
    }
}
