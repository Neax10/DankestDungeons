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

        System.out.println("Welcome to the tavern! What will you do?");
        System.out.println("[1] Go on an adventure!");
        System.out.println("[2] Start a brawl!");
        System.out.println("[3] Check the status!");
        System.out.println("[4] Drink a beer!");
        System.out.println("[5] Leave the tavern");
        System.out.println("[6] Free healing!");
        System.out.println("[7] " + color.getBlue() + "Dev. level up" + color.getDefault());

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
            village.inVillage();
        } else if (inTavern == 6) {
            player.devHealPlayer();
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 7) {

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
