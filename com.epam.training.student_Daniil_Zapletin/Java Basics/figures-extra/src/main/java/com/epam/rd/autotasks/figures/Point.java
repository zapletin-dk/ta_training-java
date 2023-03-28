package com.epam.rd.autotasks.figures;

class Point {
    private static final double ERROR_DELTA = 1e-10;
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(Point point) {

        return Math.abs(this.getX() - point.getX()) <= ERROR_DELTA && Math.abs(this.getY() - point.getY()) <= ERROR_DELTA;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
