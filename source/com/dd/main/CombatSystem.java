package com.dd.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CombatSystem {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    Color color = new Color();
    public boolean inCombat;

    public void combatSystem(Monster monster) throws InterruptedException {
        Player player = Player.getPlayer();
        Item item = new Item();
        Tavern tavern = new Tavern();


        inCombat = true;
        int rndCnt = 1;
        //monster erscheint
        monster.monsterCheckStats();
        System.out.println("A wild " + monster.getName() + " appeared!");
        System.out.println("A " + monster.getName() + " level " + monster.getLvl() + " wants to fight against you!");
        while (inCombat) {

            //auswahl tätigen (kämpfen, item, flüchten)
            System.out.println("TURN " + rndCnt + ". What will you do?");
            System.out.println("[1] FIGHT");
            System.out.println("[2] ITEM");
            System.out.println("[3] FLEE");
            System.out.println("[98] " + color.getBlue() + "Dev. heal" + color.getDefault());
            System.out.println("[99] " + color.getBlue() + "Dev. kill" + color.getDefault());
            //TODO: command input befehl

            int cmd = in.nextInt();
            in.nextLine();

            //FIGHT
            if (cmd == 1) {
                player.calcPlayerStats();
                monster.monsterCheckStats();
                System.out.println(player.getMinBaseAttack() + " - " + player.getMaxBaseAttack());
                //player führt schritt aus
                int critc = (int)(rand.nextFloat() * 100 + 1);

                if (player.getCrit() >= critc){
                    monster.setHp(monster.getHp() - player.getAttack() * 2);
                    System.out.println("Critical strike!");
                    System.out.println("You did " + player.getAttack() * 2 + " damage.");
                    System.out.println("The " + monster.getName() + " has " + monster.getHp() + "/" + monster.getMaxhp() + " HP left.");
                } else {
                    monster.setHp(monster.getHp() - player.getAttack());
                    System.out.println("You did " + player.getAttack() + " damage.");
                    System.out.println("The " + monster.getName() + " has " + monster.getHp() + "/" + monster.getMaxhp() + " HP left.");
                }

                System.out.println(" ");

                //gegner führt schritt aus
                int dodgec = (int)(rand.nextFloat() * 100 + 1);

                if (player.getDodge() >= dodgec) {
                    System.out.println("You dodged the attack!");
                } else {
                    player.setHp(player.getHp() - monster.getAttack());
                    System.out.println("The " + monster.getName() + " did " + monster.getAttack() + " damage.");
                    System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                }
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
                System.out.println(" ");
                inCombat = false;
                tavern.inTavern();
            } else if (cmd == 98) {
                player.devHealPlayer();
            } else if (cmd == 99) {
                System.out.println("You won!");
                System.out.println(" ");
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