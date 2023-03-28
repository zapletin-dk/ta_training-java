package com.epam.rd.autotasks.figures;

import java.util.Arrays;

import static java.lang.Math.sqrt;

class Triangle extends Figure{
    private final Segment side_AB, side_BC, side_AC;
    Point[] points;

    Triangle (Point a, Point b, Point c){

        side_AB = new Segment(a, b);
        side_BC = new Segment(b, c);
        side_AC = new Segment(a, c);
        points = new Point[] {a, b, c};

        if (!sideCondition()){ throw new IllegalArgumentException("Not a triangle at all"); }
    }

    public boolean sideCondition() {
        double[] sides = {side_AC.length(), side_BC.length(), side_AB.length()};
        Arrays.sort(sides);
        return (sides[0] + sides[1] > sides[2]);
    }
    public double halfPerimeter(){
        return (side_AB.length() + side_AC.length() + side_BC.length()) / 2 ;
    }

    @Override
    public double area() {
        return sqrt(halfPerimeter() * (halfPerimeter() - side_BC.length()) * (halfPerimeter() - side_AB.length()) * (halfPerimeter() - side_AC.length()));
    }

    @Override
    public String pointsToString() {
        StringBuilder sb = new StringBuilder();
        for (Point point : points){
            sb.append("(").append(point.getX()).append(',').append(point.getY()).append(")");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point minPoint = points[0];
        for (Point point: points) {
            if (minPoint.getX() > point.getX()) { minPoint = point;}
        }
        return minPoint;
    }
}
