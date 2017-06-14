package com.dd.main;

import java.util.Random;
import java.util.Scanner;

public class Village {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    public void inVillage() {
        Player player = Player.getPlayer();
        Tavern tavern = new Tavern();
        Shop shop = new Shop();
        Status status = new Status();
        System.out.println("Welcome to the inVillage! What will you do?");
        System.out.println("[1] Go to the tavern!");
        System.out.println("[2] Go shopping!");
        System.out.println("[3] Check the status!");

        int Village = in.nextInt();
        in.nextLine();
        if (Village == 1) {
            tavern.inTavern();
            //SHOPPING
        } else if (Village == 2) {
                shop.Shop();
        } else if (Village == 3) {
            status.setPreLocation(1);
            status.statusCheck();
        } else {
            System.out.println("Please enter a valid number!");
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
