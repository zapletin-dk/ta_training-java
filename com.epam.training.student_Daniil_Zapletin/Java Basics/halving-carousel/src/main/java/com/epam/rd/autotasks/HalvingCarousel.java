package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel{
    public HalvingCarousel(int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run() {
        if (!called) {
            called = true;
            return new HalvingCarouselRun();
        } else {
            return null;
        }
    }
}
