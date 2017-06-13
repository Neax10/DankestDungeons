package com.dd.main;


import java.util.Random;
import java.util.Scanner;

public class Status {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

    public void statusCheck() {
        Village village = new Village();
        Player player = Player.getPlayer();
        Player.EquippedWeapon equippedweapon = player.new EquippedWeapon();
        Status status = new Status();

        boolean inStatus = true;
        while (inStatus) {
            System.out.println("You are level " + player.getLvl() + " with " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You have equipped " + equippedweapon.getName() + "!");
            System.out.println("You deal " + player.getMinBaseAttack() + "-" + player.getMaxBaseAttack() + " damage!"); //TODO: attackdamage with additions of weopons etc.
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP!");
            if (player.getHp() < player.getMaxhp()) {
                System.out.println("You can heal your hit points in the tavern!");
            }
            System.out.println("You have " + player.getGold() + " Gold!");
            System.out.println("You have " + player.getStatusPoints() + " statuspoints!");
            System.out.println(" ");
            System.out.println("Do you want to use them?");
            System.out.println("[1] Yes!");
            System.out.println("[2] No!");

            int skillen = in.nextInt();
            in.nextLine();

            boolean inSkilling = true;
            while (inSkilling) {
                if (skillen == 1) {
                    System.out.println("Stats: ");
                    System.out.println("Strength: " + player.getStrength());
                    System.out.println("Intelligence: " + player.getIntelligence());
                    System.out.println("Vitality: " + player.getVitality());
                    System.out.println("Dexterity: " + player.getDexterity());
                    System.out.println("Luck: " + player.getLuck());
                    System.out.println(" ");
                    System.out.println("What would you like to increase?");
                    System.out.println("[1] Strength!");
                    System.out.println("[2] Intelligence!");
                    System.out.println("[3] Vitality!");
                    System.out.println("[4] Dexterity!");
                    System.out.println("[5] Luck");
                    System.out.println("[6] Nothing!");

                    int statusPointsSkillen = in.nextInt();
                    in.nextLine();
                    if (statusPointsSkillen == 1) {
                        System.out.println("How many points do you want to skill in Strength?");

                        statusPointsSkillen = in.nextInt();
                        in.nextLine();

                        if (statusPointsSkillen <= player.getStatusPoints()) {
                            player.setStatusPoints(player.getStatusPoints() - statusPointsSkillen);
                            player.setStrength(player.getStrength() + statusPointsSkillen);
                            inSkilling = false;
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (statusPointsSkillen == 2) {
                        System.out.println("How many points do you want to skill in Intelligence?");

                        statusPointsSkillen = in.nextInt();
                        in.nextLine();
                        if (statusPointsSkillen <= player.getStatusPoints()) {
                            player.setStatusPoints(player.getStatusPoints() - statusPointsSkillen);
                            player.setIntelligence(player.getIntelligence() + statusPointsSkillen);
                            inSkilling = false;
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (statusPointsSkillen == 3) {
                        System.out.println("How many points do you want to skill in Vitality?");

                        statusPointsSkillen = in.nextInt();
                        in.nextLine();

                        if (statusPointsSkillen <= player.getStatusPoints()) {
                            player.setStatusPoints(player.getStatusPoints() - statusPointsSkillen);
                            player.setVitality(player.getVitality() + statusPointsSkillen);
                            inSkilling = false;
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (statusPointsSkillen == 4) {
                        System.out.println("How many points do you want to skill in Dexterity?");

                        statusPointsSkillen = in.nextInt();
                        in.nextLine();

                        if (statusPointsSkillen <= player.getStatusPoints()) {
                            player.setStatusPoints(player.getStatusPoints() - statusPointsSkillen);
                            player.setDexterity(player.getDexterity() + statusPointsSkillen);
                            inSkilling = false;
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (statusPointsSkillen == 5) {
                        System.out.println("How many points do you want to skill in Luck?");

                        statusPointsSkillen = in.nextInt();
                        in.nextLine();

                        if (statusPointsSkillen <= player.getStatusPoints()) {
                            player.setStatusPoints(player.getStatusPoints() - statusPointsSkillen);
                            player.setLuck(player.getLuck() + statusPointsSkillen);
                            inSkilling = false;
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (statusPointsSkillen == 6) {
                        System.out.println("");
                    } else {
                        System.out.println("Please enter a valid number!");
                        System.out.println(" ");
                    }
                } else if (skillen == 2) {
                    inStatus = false;
                    village.inVillage();
                } else {
                    System.out.println("Please enter a valid number!");
                    System.out.println(" ");
                }
            }
            System.out.println(" ");
        }
    }
}

