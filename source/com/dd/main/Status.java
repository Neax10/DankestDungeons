package com.dd.main;


import java.util.Random;
import java.util.Scanner;

public class Status {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

    private int preLocation;
    public void statusCheck() {
        Village village = new Village();
        Tavern tavern = new Tavern();
        Player player = Player.getPlayer();
        Player.EquippedWeapon equippedweapon = player.new EquippedWeapon();

        boolean inStatus = true;
        while (inStatus) {
            player.calcPlayerStats();
            int randint = Math.abs(rand.nextInt()) % 11;
            System.out.println(randint);
            System.out.println("You are level " + player.getLvl() + " with " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You have equipped " + equippedweapon.getName() + "!");
            System.out.println("You deal " + player.getMinBaseAttack() + "-" + player.getMaxBaseAttack() + " damage!"); //TODO: attackdamage with additions of weopons etc.
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP!");
            if (player.getHp() < player.getMaxhp()) {
                System.out.println("You can heal your hit points in the tavern!");
            }
            System.out.println("You have " + player.getStamina() + "/" + player.getMaxstamina() + " stamina!");
            System.out.println("You have " + player.getMana() + "/" + player.getMaxmana() + " mana!");
            System.out.println("You have " + player.getGold() + " gold!");
            System.out.println("You have " + player.getStatusPoints() + " statuspoints!");
            System.out.println(" ");


            if (player.getStatusPoints() >= 1) {
                boolean inSkilling = true;
                while (inSkilling) {
                    System.out.println("Do you want to use your skill points?");
                    System.out.println("[1] Yes!");
                    System.out.println("[2] No!");

                    int skillen = in.nextInt();
                    in.nextLine();

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
                                player.calcPlayerStats();
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
                                player.calcPlayerStats();
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
                                player.calcPlayerStats();
                                player.setHp(player.getHp() + statusPointsSkillen * 2);
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
                                player.calcPlayerStats();
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
                                player.calcPlayerStats();
                                inSkilling = false;
                            } else {
                                System.out.println("Please enter a valid number!");
                                System.out.println(" ");
                            }
                        } else if (statusPointsSkillen == 6) {
                            if (getPreLocation() == 1) {
                                inStatus = false;
                                village.inVillage();
                            } else if (getPreLocation() == 2) {
                                inStatus = false;
                                tavern.inTavern();
                            } else {
                                System.out.println("ERROR: Location not found!");
                            }
                        } else {
                            System.out.println("Please enter a valid number!");
                            System.out.println(" ");
                        }
                    } else if (skillen == 2) {
                        if (getPreLocation() == 1) {
                            inStatus = false;
                            village.inVillage();
                        } else if (getPreLocation() == 2) {
                            inStatus = false;
                            tavern.inTavern();
                        } else {
                            System.out.println("ERROR: Location not found!");
                        }

                    } else {
                        System.out.println("Please enter a valid number!");
                        System.out.println(" ");
                    }
                }
                System.out.println(" ");
            } else {
                if (getPreLocation() == 1) {
                    inStatus = false;
                    village.inVillage();
                } else if (getPreLocation() == 2) {
                    inStatus = false;
                    tavern.inTavern();
                } else {
                    System.out.println("ERROR: Location not found!");
                }
            }
        }
    }

    public int getPreLocation() {
        return preLocation;
    }

    public void setPreLocation(int preLocation) {
        this.preLocation = preLocation;
    }
}

