package com.epam.rd.autotasks.intersection;
public class Line {
    int k;
    int b;
    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        //throw new UnsupportedOperationException();
        if (k != other.k) {
            int crossX;
            int crossY;
            crossX = (other.b - b) / (k - other.k);
            crossY = k * crossX + b;
            return new Point(crossX, crossY);
        } else {return null;}
    }

}
