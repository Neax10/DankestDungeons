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
        Monster myMonster = dbc.getMonsterfromID(1);
        String test = myMonster.getName();
        System.out.println("We have a monster with the Name = " + test);
        //dbc.handleDB();
    }

    public void initializeGame() {
        initDatabase();
        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        Player.getPlayer().setName(in.nextLine());
        System.out.println("Hello " + Player.getPlayer().getName() + " there are many adventures awaiting you!");
    }
}

