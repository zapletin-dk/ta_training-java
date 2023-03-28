package com.epam.rd.autotasks.figures;

abstract class Figure{
    public static final double ERROR_DELTA = 1e-10;

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
