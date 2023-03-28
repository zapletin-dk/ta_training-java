package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private final Point[] points;
    private final Segment side_AB, side_BC, side_CD, side_DA, diagonal_AC, diagonal_BD;

    public Quadrilateral(Point vertice_A, Point vertice_B, Point vertice_C, Point vertice_D) {

        this.side_AB = new Segment(vertice_A, vertice_B);
        this.side_BC = new Segment(vertice_B, vertice_C);
        this.side_CD = new Segment(vertice_C, vertice_D);
        this.side_DA = new Segment(vertice_D, vertice_A);
        this.diagonal_AC = new Segment(vertice_A, vertice_C);
        this.diagonal_BD = new Segment(vertice_B, vertice_D);
        points = new Point[]{vertice_A, vertice_B, vertice_C, vertice_D};
        if (Math.abs(side_AB.length() - side_BC.length()) > side_CD.length() + side_DA.length()){
            throw new IllegalArgumentException("Seems like it's self-crossing quadrilaterals");
        }
    }

    @Override
    public double area() {
        return Math.sqrt((halfPerimeter() - side_AB.length()) * (halfPerimeter() - side_BC.length()) *
                (halfPerimeter() - side_CD.length()) * (halfPerimeter() - side_DA.length()) +
                0.25 * (Math.pow(diagonal_AC.length() * diagonal_BD.length(),2) -
                Math.pow(side_AB.length() * side_CD.length() + side_BC.length() * side_DA.length(),2)));
    }
    public double halfPerimeter(){
        return (side_AB.length() + side_BC.length() + side_CD.length()+ side_DA.length()) / 2 ;
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
            if (minPoint.getX() > point.getX()) { minPoint = point; }
        }
        return minPoint;
    }
}
