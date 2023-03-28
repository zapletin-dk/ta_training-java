package com.epam.rd.autotasks.figures;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start, end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if ((start.getX() == end.getX()) &&
                (start.getY() == end.getY())) {
            throw new IllegalArgumentException("You can't make side with two equal dots");
        }
    }
    double length() {
        return sqrt(
                pow(end.getX() - start.getX(), 2) +
                        pow(end.getY() - start.getY(), 2));
    }
}
