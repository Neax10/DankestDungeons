package com.dd.main;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import static com.dd.main.Player.*;

public class Main {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    CombatSystem combatSystem = new CombatSystem();

    public static void main(String[] args) {
        Main m = new Main();
        m.initializeGame();
    }

    public void initializeGame() {
        DBController dbc = DBController.getInstance();
        Inventory inventory = Inventory.getInventory();
        dbc.initDBConnection();
        Title title = new Title();

        title.Title();
        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        getPlayer().setName(in.nextLine());
        System.out.println("Hello " + getPlayer().getName() + " there are many adventures awaiting you!");
        System.out.println(" ");

        initDatabase();
        getMonster();
    }

    public void initDatabase() {
        DBController dbc = DBController.getInstance();
        dbc.initDBConnection();
    }

    public void getMonster(){
        DBController dbc = DBController.getInstance();
        Monster myMonster = dbc.getMonsterfromID(rand.nextInt(7) + 1);
        String test = myMonster.getName();
        System.out.println("We have a monster with the Name = " + test);
        System.out.println(" ");
        try {
            combatSystem.combatSystem(myMonster);
        } catch (InterruptedException e) {
            //TODO: ERROR HANDLING
            e.printStackTrace();
        }
        //dbc.handleDB();
    }

    public void getBruiser(){
        DBController dbc = DBController.getInstance();
        Player player = getPlayer();
        int id = player.getNextbruiserid();
        Bruiser bruiser = dbc.getBruiserfromID(id);
        String test = bruiser.getName();
        System.out.println("There is a " + test);
        System.out.println(" ");
        try {
            combatSystem.combatSystem(bruiser);
        } catch (InterruptedException e) {
            //TODO: ERROR HANDLING
            e.printStackTrace();
        }
        //dbc.handleDB();
    }
}