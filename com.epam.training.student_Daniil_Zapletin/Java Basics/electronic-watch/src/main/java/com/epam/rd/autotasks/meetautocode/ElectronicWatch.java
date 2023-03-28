package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours, minutes, seconds = scanner.nextInt();

        hours = seconds/(60 * 60) ;
        minutes = (seconds - hours * (60 * 60)) / 60;
        seconds = (seconds - hours * (60 * 60) - minutes * 60);
        int formattedHours = hours >= 24 ? hours -hours/24 * 24 : hours;

        System.out.printf("%d:%02d:%02d%n", formattedHours, minutes, seconds);
    }
}
