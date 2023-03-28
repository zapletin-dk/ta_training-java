package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    Point center;
    double radius;
    public Circle(Point center, double radius) {
        if (radius <= 0) {throw new IllegalArgumentException("Radius can't be less than or equal to zero!");}
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String pointsToString() {
        return "(" + center.getX() + "," + center.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }
}
