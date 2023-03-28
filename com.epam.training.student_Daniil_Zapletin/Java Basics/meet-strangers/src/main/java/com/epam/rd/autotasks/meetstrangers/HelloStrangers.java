package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counterOfPeople = Integer.parseInt(scan.nextLine());
        if (counterOfPeople == 0){
            System.out.println("Oh, it looks like there is no one here");
        } else if (counterOfPeople < 0) {
            System.out.println("Seriously? Why so negative?");
        }else {
            for (int i = 0; i < counterOfPeople; i++) {
                System.out.printf("Hello, %s\n", scan.nextLine());
            }
        }
    }
}
