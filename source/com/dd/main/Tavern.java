package com.dd.main;

import java.util.Random;
import java.util.Scanner;

public class Tavern {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    private Player player = Player.getPlayer();

    public void inTavern(){
        Village village = new Village();

        System.out.println("Welcome to the Tavern! What will you do?");
        System.out.println("[1] Go on an adventure!");
        System.out.println("[2] Start a brawl!");
        System.out.println("[3] Check the status!");
        System.out.println("[4] Free healing!");
        System.out.println("[5] Leave the tavern");
        System.out.println("[6] Dev. Level up");

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
            System.out.println("Hello " + player.getName() + "!");
            System.out.println("You are level " + player.getLvl() + " with " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You deal " + player.getMinBaseAttack() + "-" + player.getMaxBaseAttack() + " damage!"); //TODO: attackdamage with additions of weopons etc.
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP!");
            if (player.getHp() < player.getMaxhp()) {
                System.out.println("You can heal your hit points in the tavern!");
            }
            System.out.println("You have " + player.getGold() + " Gold!");
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 4) {
            player.healPlayer();
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 5) {
            village.inVillage();
        } else if (inTavern == 6) {

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
