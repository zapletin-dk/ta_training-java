package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int upFeetPerDay = scan.nextInt(), downFeetPerNight = scan.nextInt(), treeHeight = scan.nextInt();
        int distanceTraveled = 0;
        int countOfDays = 0;
        if (upFeetPerDay > downFeetPerNight || upFeetPerDay >= treeHeight){
            while (distanceTraveled <= treeHeight){
                if (distanceTraveled + upFeetPerDay < treeHeight) {
                    distanceTraveled += upFeetPerDay - downFeetPerNight;
                    countOfDays++;
                } else {
                    System.out.println(++countOfDays);
                    break;
                }
            }
        } else {
            System.out.println("Impossible");
        }
    }
}
