package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int pizzaSlices = scanner.nextInt();
        int newPizza = pizzaSlices;
        int counter = 1;
        while (newPizza % people !=0){
            newPizza += pizzaSlices;
            counter++;
        }
        System.out.println(counter);
    }
}
