package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point center;
    double radius;
    public Circle(Point center, double radius) {
        if ( radius <= 0 || center == null) {throw new IllegalArgumentException("Radius can't be less than or equal to zero!");}
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid(){ return this.center; }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this.getClass() == figure.getClass()){
            return this.center.equals(((Circle)figure).center) && this.radius - ((Circle) figure).radius < ERROR_DELTA;
        }
        return false;
    }

    public String pointsToString() {
        return "(" + center.getX() + "," + center.getY() + ")";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

}
