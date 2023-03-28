package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOfDigits = 0;
        int counterOfDigits = 0;
        int digit  = scanner.nextInt();
        while (digit != 0){
            sumOfDigits += digit;
            digit = scanner.nextInt();
            counterOfDigits++;
        }
        System.out.println(sumOfDigits / counterOfDigits);
    }
}