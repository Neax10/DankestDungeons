package com.dd.main;

import java.util.Random;
import java.util.Scanner;

public class Tavern {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    private Player player = Player.getPlayer();
    private Color color = new Color();

    public void inTavern(){
        Village village = new Village();
        Status status = new Status();
        Rumors rumors = new Rumors();

        System.out.println("Welcome to the tavern! What will you do?");
        System.out.println("[1] Go on an adventure!");
        System.out.println("[2] Start a brawl!");
        System.out.println("[3] Check the status!");
        System.out.println("[4] Drink a beer!");
        System.out.println("[5] Listen for rumors!");
        System.out.println("[6] Go on your quest!"); //TODO: Quest stuff
        System.out.println("[7] Leave the tavern");
        System.out.println("[98] " + color.getBlue() + "Dev. healing!" + color.getDefault());
        System.out.println("[99] " + color.getBlue() + "Dev. level up!" + color.getDefault());

        int inTavern = in.nextInt();
        in.nextLine();

        //ADVENTURE
        if (inTavern == 1) {
            Main m = new Main();
            System.out.println("You start an Adventure!");
            System.out.println(" ");
            m.initDatabase();
            //BRAWL
        } else if (inTavern == 2) {
            //TODO: Brawl system
            System.out.println("There are no opponent's!");
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 3) {
            status.setPreLocation(2);
            status.statusCheck();
        } else if (inTavern == 4) {
            player.drinkABeer();
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 5) {
            rumors.listenForARumor();
            inTavern();
        } else if (inTavern == 6) {
            System.out.println("ERROR: No quest system found!");
            inTavern();
        } else if (inTavern == 7) {
            village.inVillage();
        } else if (inTavern == 98) {
            player.devHealPlayer();
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 99) {

            System.out.println("You are level " + player.getLvl() + ". How many level ups do you want?");

            int lvlup = in.nextInt();
            in.nextLine();

            for (int lvl = 0; lvl < lvlup ; lvl++){
                player.setXp(player.getNexxp());
                player.calcPlayerLevel();
            }
            inTavern();

        } else {
            System.out.println("Please enter a valid number!");
            System.out.println(" ");
            inTavern();
        }
    }
}