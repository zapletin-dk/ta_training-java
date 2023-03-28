package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = a;
        while (a != 0){
            a = scan.nextInt();
            if ((b < a) && a!=0){
                b = a;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(max());
    }
}
