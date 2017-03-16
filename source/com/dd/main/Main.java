package com.dd.main;

import java.util.Scanner;

public class Main {
    private static String playerName;
    private Scanner in = new Scanner(System.in);

    //Moritz kann stuff schreiben
    public static void main(String[] args) {
        Main m = new Main();
        m.initializeGame();

    }

    public void initializeGame() {
        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        playerName = in.nextLine();
        System.out.println("Hello " + playerName + " there are many adventures awaiting you!");
    }
}
