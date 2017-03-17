package com.dd.main;

import java.util.Scanner;

public class Main {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        m.initializeGame();

    }

    public void initDatabase() {
        DBController dbc = DBController.getInstance();
        dbc.initDBConnection();
        //dbc.handleDB();
    }

    public void initializeGame() {
        initDatabase();
        Player player = new Player();
        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        player.setName(in.nextLine());
        System.out.println("Hello " + player.getName() + " there are many adventures awaiting you!");

    }
}

