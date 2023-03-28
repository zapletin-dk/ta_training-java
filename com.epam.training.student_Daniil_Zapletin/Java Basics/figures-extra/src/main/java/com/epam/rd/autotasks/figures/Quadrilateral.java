package com.epam.rd.autotasks.figures;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;
class Quadrilateral extends Figure{

    private final Point vertice_A, vertice_B, vertice_C, vertice_D;

    public Quadrilateral(Point vertice_A, Point vertice_B, Point vertice_C, Point vertice_D) {
        this.vertice_A = vertice_A;
        this.vertice_B = vertice_B;
        this.vertice_C = vertice_C;
        this.vertice_D = vertice_D;
        if (!(nullCheck() && isConvex() && !Degenerate() && (area() != 0)) ){
            throw new IllegalArgumentException();}

    }

    private boolean nullCheck() {
        return vertice_A != null && vertice_B != null && vertice_D != null && vertice_C != null;
    }
    private boolean isConvex(){
        double areaABC = new Triangle(vertice_A, vertice_B, vertice_C).area();
        double areaADC = new Triangle(vertice_A, vertice_D, vertice_C).area();
        double areaABD = new Triangle(vertice_A, vertice_B, vertice_D).area();
        double areaCBD = new Triangle(vertice_C, vertice_B, vertice_D).area();
        return areaABC + areaADC == areaABD + areaCBD;
    }

    private boolean Degenerate(){
        double AB = sqrt(pow((vertice_B.getX()- vertice_A.getX()), 2) + pow((vertice_B.getY()- vertice_A.getY()), 2));
        double BC = sqrt(pow((vertice_C.getX()- vertice_B.getX()), 2) + pow((vertice_C.getY()- vertice_B.getY()), 2));
        double CD = sqrt(pow((vertice_D.getX()- vertice_C.getX()), 2) + pow((vertice_D.getY()- vertice_C.getY()), 2));
        double DA = sqrt(pow((vertice_A.getX()- vertice_D.getX()), 2) + pow((vertice_A.getY()- vertice_D.getY()), 2));
        return !(AB + BC + CD > DA && BC + CD + DA > AB && CD + DA + AB > BC && DA + AB + BC > CD);
    }
    private double area() {
        return Math.abs((vertice_A.getX()-vertice_B.getX()) * (vertice_A.getY()+vertice_B.getY()) +
                (vertice_B.getX()-vertice_C.getX()) * (vertice_B.getY()+vertice_C.getY()) +
                (vertice_C.getX()-vertice_D.getX()) * (vertice_C.getY()+vertice_D.getY()) +
                (vertice_D.getX()-vertice_A.getX()) * (vertice_D.getY()+vertice_A.getY()))/2;
    }
    @Override
    public Point centroid() {
        Point centroidABC = new Triangle(vertice_A, vertice_B, vertice_C).centroid();
        Point centroidADC = new Triangle(vertice_A, vertice_D, vertice_C).centroid();
        Point centroidABD = new Triangle(vertice_A, vertice_B, vertice_D).centroid();
        Point centroidCBD = new Triangle(vertice_C, vertice_B, vertice_D).centroid();

        return intersection(centroidABC, centroidADC, centroidABD, centroidCBD);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double areaDelta = Math.abs(area() - ((Quadrilateral) figure).area());
        double centroidDeltaX = Math.abs(centroid().getX() - figure.centroid().getX());
        double centroidDeltaY = Math.abs(centroid().getY() - figure.centroid().getY());
        return getClass() == figure.getClass() && areaDelta < ERROR_DELTA && centroidDeltaX < ERROR_DELTA && centroidDeltaY < ERROR_DELTA;
    }

    Point intersection(Point midAB, Point midDC, Point midBC, Point midAD) {
        Point point;
        if ((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()) != 0){
            double xPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getX()- midAD.getX())-(midAB.getX()-midDC.getX())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            if (xPoint == -0) xPoint = 0;
            double yPoint = (((midAB.getX()*midDC.getY()-midAB.getY()*midDC.getX())*(midBC.getY()- midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()* midAD.getY()-midBC.getY()*midAD.getX())))/((midAB.getX()-midDC.getX())*(midBC.getY()-midAD.getY())-(midAB.getY()-midDC.getY())*(midBC.getX()-midAD.getX()));
            if (yPoint == -0) yPoint = 0;
            int checkPoint = (int) (((xPoint-midAB.getX())*(midDC.getY()-midAB.getY()))-((yPoint-midAB.getY())*(midDC.getX()-midAB.getX())));
            int checkPointAnother = (int) (((xPoint-midBC.getX())*(midAD.getY()-midBC.getY()))-((yPoint-midBC.getY())*(midAD.getX()-midBC.getX())));
            if (checkPoint == 0 && checkPointAnother == 0){
                if (xPoint >= midAB.getX() && xPoint <= midDC.getX() || xPoint >= midDC.getX() && xPoint <= midAB.getX()){
                    if (xPoint >= midBC.getX() && xPoint <= midAD.getX() || xPoint >= midAD.getX() && xPoint <= midBC.getX()){
                        point = new Point(xPoint, yPoint);
                    }else{
                        point = null;
                    }
                } else {
                    point = null;
                }
            } else {
                point = null;
            }
        } else {
            point = null;
        }
        return point;
    }
}
