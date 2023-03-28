package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int billTotall = scan.nextInt();
        billTotall += billTotall/10;
        int amountOfFriends = scan.nextInt();
        if (billTotall >= 0 ){
            if (amountOfFriends > 0) {
                System.out.println(billTotall/amountOfFriends);
            } else {
                System.out.println("Number of friends cannot be negative or zero");
            }
        } else {
            System.out.println("Bill total amount cannot be negative");
        }
    }
}
