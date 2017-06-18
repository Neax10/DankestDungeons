package com.dd.main;


import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Status {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

    private int preLocation;
    public void statusCheck() {
        DBController dbc = DBController.getInstance();
        Village village = new Village();
        Tavern tavern = new Tavern();
        Player player = Player.getPlayer();
        Player.EquippedWeapon equippedweapon = player.new EquippedWeapon();
        Inventory inventory = Inventory.getInventory();

        boolean inStatus = true;
        while (inStatus) {
            player.calcPlayerStats();
            System.out.println("You are level " + player.getLvl() + " with " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You have equipped: " + equippedweapon.getName() + "!");
            System.out.println("You deal " + player.getMinBaseAttack() + "-" + player.getMaxBaseAttack() + " damage!"); //TODO: attackdamage with additions of weopons etc.
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP!");
            if (player.getHp() < player.getMaxhp()) {
                System.out.println("You can heal your hit points in the tavern!");
            }
            System.out.println("You have a " + player.getCrit() + "% chance to deal critical damage!");
            System.out.println("You have a " + player.getDodge() + "% chance to dodge the enemy attack!");
            System.out.println("You have " + player.getStamina() + "/" + player.getMaxstamina() + " stamina!");
            System.out.println("You have " + player.getMana() + "/" + player.getMaxmana() + " mana!");
            System.out.println("You have " + player.getGold() + " gold!");
            System.out.println("You have " + player.getStatusPoints() + " statuspoints!");
            System.out.println(" ");

            System.out.println("What do you want to do?");
            System.out.println("[1] Look at inventory!");
            System.out.println("[2] Equip weapon!");
            System.out.println("[3] Equip armor!");
            if (player.getStatusPoints() >= 1)
            System.out.println("[4] Use skill points!");
            System.out.println("[5] Nothing!");
            int status = in.nextInt();
            in.nextLine();
            //LOOK AT INVENTORY
            if (status == 1){
                System.out.println("Weapons: ");
                inventory.showinventory(1, 0);
                System.out.println("Armors: ");
                inventory.showinventory(2, 0);
                System.out.println("Items: ");
                inventory.showinventory(3, 0);
                //EQUIP WEAPON
            } else if (status == 2) {

                System.out.println("Weapons: ");
                System.out.println("[1] Fists");
                inventory.showinventory(1, 1);
                System.out.println("[0] No!");
                System.out.println("");
                System.out.println("Which weapon do you want to equip?");
                int equipweapon = in.nextInt();
                in.nextLine();

                Weapon weapon = dbc.getWeaponfromID(equipweapon);
                if (equipweapon == 1){
                    inventory.setUsesuccsess(1);
                } else {
                    inventory.removeItem(1, equipweapon, 1);
                }
                if (inventory.getUsesuccsess() == 1){

                    if (Objects.equals(equippedweapon.getName(), "Fists")){
                        if (Objects.equals(weapon.getName(), "Fists")){
                        } else {
                            System.out.println("You equipped: " + weapon.getName() + "!");
                            System.out.println("");
                        }
                    } else {
                        inventory.fillSlot(1, player.getWeapon(), 1);
                        System.out.println("You put " + equippedweapon.getName() + " in your inventory!");
                        if (Objects.equals(weapon.getName(), "Fists")){
                        } else {
                            System.out.println("and equipped: " + weapon.getName() + "!");
                        }
                        System.out.println("");
                    }

                    player.setWeapon(weapon.getId());
                    equippedweapon.setName(weapon.getName());
                    equippedweapon.setLevel(weapon.getLevel());
                    equippedweapon.setDmgmin(weapon.getDmgmin());
                    equippedweapon.setDmgmax(weapon.getDmgmax());
                    equippedweapon.setHanded(weapon.getHanded());
                    equippedweapon.setBuyprice(weapon.getBuyprice());
                    equippedweapon.setSellprice(weapon.getSellprice());
                    equippedweapon.setTradable(weapon.getTradable());

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

            } else if (status == 3){
                System.out.println("NO ARMOR IMPLEMENTED!");
            } else if (player.getStatusPoints() >= 1 && status == 4) {
                boolean inSkilling = true;
                while (inSkilling) {

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
                }
                System.out.println(" ");
            } else if (status == 5){
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
    }

    public int getPreLocation() {
        return preLocation;
    }

    public void setPreLocation(int preLocation) {
        this.preLocation = preLocation;
    }
}

