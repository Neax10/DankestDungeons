package com.dd.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CombatSystem {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

    public void combatSystem(Monster monster) throws InterruptedException {
        Player player = Player.getPlayer();
        Tavern tavern = new Tavern();
        boolean inCombat = true;
        int rndCnt = 1;
        //monster erscheint
        System.out.println("A wild " + monster.getName() + " appeared!");
        System.out.println("A " + monster.getName() + " wants to fight against you!");
        while (inCombat) {

            //auswahl tätigen (kämpfen, item, flüchten)
            System.out.println("TURN " + rndCnt + ". What will you do?");
            System.out.println("[1] FIGHT");
            System.out.println("[2] ITEM");
            System.out.println("[3] FLEE");
            System.out.println("[4] Dev. Heal");
            System.out.println("[5] Dev. Kill");
            //TODO: command input befehl

            int cmd = in.nextInt();
            in.nextLine();

            //FIGHT
            if (cmd == 1) {
                player.calcPlayerDmg();
                System.out.println(player.getMinBaseAttack() + " - " + player.getMaxBaseAttack());
                //player führt schritt aus
                monster.setHp(monster.getHp() - player.getAttack());
                System.out.println("You did " + player.getAttack() + " damage");
                System.out.println("The " + monster.getName() + " has " + monster.getHp() + "/" + monster.getMaxhp() + " HP left.");

                //gegner führt schritt aus
                player.setHp(player.getHp() - monster.getAttack());
                System.out.println("The " + monster.getName() + " did " + monster.getAttack() + " damage");
                System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                TimeUnit.SECONDS.sleep(1);

                if (player.getHp() <= 0) {
                    System.out.println("You died!");
                    inCombat = false;
                } else if (monster.getHp() <= 0) {
                    System.out.println("You won!");
                    inCombat = false;
                    player.setGold(player.getGold() + monster.getGold());
                    player.setXp(player.getXp() + monster.getXp());
                    System.out.println("You gained " + monster.getGold() + " Gold");
                    System.out.println("and " + monster.getXp() + " XP!");
                    player.checkPlayerLvl();
                }
                rndCnt++;

                //ITEM
            } else if (cmd == 2) {
                boolean itemuse = false;

                //TODO: ITEMS
                //ITEM used true/false
                if (itemuse) {
                    System.out.println("You successfully used " + "item" + "!");
                    System.out.println(" ");
                    //gegner führt schritt aus

                    player.setHp(player.getHp() - monster.getAttack());
                    System.out.println("The " + monster.getName() + " did " + monster.getAttack() + " damage");
                    System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                    TimeUnit.SECONDS.sleep(1);
                    if (player.getHp() <= 0) {
                        System.out.println("You died!");
                        inCombat = false;
                    } else if (monster.getHp() <= 0) {
                        System.out.println("You won!");
                        inCombat = false;
                        player.setGold(player.getGold() + monster.getGold());
                        player.setXp(player.getXp() + monster.getXp());
                        System.out.println("You gained " + monster.getGold() + " Gold");
                        System.out.println("and " + monster.getXp() + " XP!");
                        player.checkPlayerLvl();
                    }
                    rndCnt++;

                } else {
                    System.out.println("You didn't use any item!");
                }

                //FLEE
            } else if (cmd == 3) {
                System.out.println("You escaped!");
                inCombat = false;
            } else if (cmd == 4) {
                player.healPlayer();
            } else if (cmd == 5) {
                System.out.println("You won!");
                inCombat = false;
                player.setGold(player.getGold() + monster.getGold());
                player.setXp(player.getXp() + monster.getXp());
                System.out.println("You gained " + monster.getGold() + " Gold");
                System.out.println("and " + monster.getXp() + " XP!");
                player.checkPlayerLvl();
            } else {
                System.out.println("Please enter a valid number!");
            }
            System.out.println(" ");


        }
        tavern.inTavern();
    }
}