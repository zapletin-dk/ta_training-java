package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle extends Figure {
    Point vertice_A;
    Point vertice_B;
    Point vertice_C;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.vertice_A = pointA;
        this.vertice_B = pointB;
        this.vertice_C = pointC;

        if (!(nullCheck() && !Degenerate() && area() != 0)){throw new IllegalArgumentException();}
    }
    private boolean Degenerate(){
        double AB = sqrt(pow((vertice_B.getX()- vertice_A.getX()), 2)+pow((vertice_B.getY()- vertice_A.getY()), 2));
        double BC = sqrt(pow((vertice_C.getX()- vertice_B.getX()), 2)+pow((vertice_C.getY()- vertice_B.getY()), 2));
        double CA = sqrt(pow((vertice_A.getX()- vertice_C.getX()), 2)+pow((vertice_A.getY()- vertice_C.getY()), 2));
        return !(AB + BC > CA) || !(BC + CA > AB) || !(CA + AB > BC);
    }

    double area() {
        return Math.abs((vertice_B.getX()- vertice_A.getX()) * (vertice_C.getY()- vertice_A.getY()) -
                        (vertice_C.getX()- vertice_A.getX()) * (vertice_B.getY()- vertice_A.getY()))/2;
    }
    @Override
    public Point centroid(){
        return new Point((vertice_A.getX()+ vertice_B.getX()+ vertice_C.getX())/3,(vertice_A.getY()+ vertice_B.getY()+ vertice_C.getY())/3);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Triangle) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        return getClass() == figure.getClass() && areaDelta < ERROR_DELTA && centroidDeltaX < ERROR_DELTA && centroidDeltaY < ERROR_DELTA;
    }


    private boolean nullCheck(){
        return vertice_A != null && vertice_B != null && vertice_C != null;
    }

}