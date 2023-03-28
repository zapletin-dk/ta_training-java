package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

/**
 * Quadratic equation coefficients (ax2 + bx + c = 0) are given by user
 * variable d is a discriminant
 */
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = Math.pow(b, 2) -4 * a *c;
        double v = 2 * a;
        if (d > 0){
            System.out.print( (-b + Math.sqrt(d)) /  v);
            System.out.print(" " + (-b - Math.sqrt(d))/ v);
        } else if (d == 0){
            System.out.println(-b/v);
        } else {
            System.out.println("no roots");
        }

    }

}