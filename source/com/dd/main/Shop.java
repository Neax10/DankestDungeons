package com.dd.main;

import java.util.Scanner;

public class Shop {

    public void Shop() {
        DBController dbc = DBController.getInstance();
        Scanner in = new Scanner(System.in);
        Player player = Player.getPlayer();
        Player.EquippedWeapon equipweapon = player.new EquippedWeapon();
        Village village = new Village();

        boolean inShop = true;
        while (inShop){
            System.out.println("You have " + player.getGold() + " Gold. What do you want to buy?");
            System.out.println("[1] Weapon");
            System.out.println("[2] Armor");
            System.out.println("[3] Item");
            System.out.println("[4] Leave Shop");

            int Shop = in.nextInt();
            in.nextLine();

            if (Shop == 1) {
                boolean weapontrader = true;
                while (weapontrader) {
                    System.out.println("Weapon: ");
                    int cnt;
                    int itm = 1;
                    for (cnt = 1; cnt <= 11; cnt++) {
                        Weapon shopweapon = dbc.getWeaponfromID(cnt);
                        if (shopweapon.getTradable() == 1) {
                            System.out.println("[" + cnt + "] " + shopweapon.getName() + ", level " + shopweapon.getLevel() + ", " + shopweapon.getDmgmin() + "-" + shopweapon.getDmgmax() + " damage, " + shopweapon.getHanded() + " Handed, " + shopweapon.getBuyprice() + " Gold");
                            itm++;
                        }
                    }
                    System.out.println(" ");
                    System.out.println("[" + cnt + "] Leave weapon trader");

                    int shopWeapons = in.nextInt();
                    in.nextLine();

                    //check weapon id
                    Weapon shopweapons = dbc.getWeaponfromID(shopWeapons);
                    //Test item line!!! System.out.println("You want to buy " + shopweapons.getName() + "!");
                    if (shopweapons.getTradable() == 1) {
                        if (shopweapons.getLevel() > player.getLvl()){
                            System.out.println("Your level is to low for this weapon!");
                            System.out.println(" ");
                        } else {
                            if (player.getGold() >= shopweapons.getBuyprice()) {
                                //Add weapon to inventory
                                player.setGold(player.getGold() - shopweapons.getBuyprice());

                                player.setWeapon(shopweapons.getId());
                                equipweapon.setName(shopweapons.getName());
                                equipweapon.setLevel(shopweapons.getLevel());
                                equipweapon.setDmgmin(shopweapons.getDmgmin());
                                equipweapon.setDmgmax(shopweapons.getDmgmax());
                                equipweapon.setHanded(shopweapons.getHanded());
                                equipweapon.setBuyprice(shopweapons.getBuyprice());
                                equipweapon.setSellprice(shopweapons.getSellprice());
                                equipweapon.setTradable(shopweapons.getTradable());

                                System.out.println("You successful bought and equipped " + shopweapons.getName() + "!");
                                System.out.println(" ");
                                player.calcPlayerStats();
                            } else {
                                System.out.println("You don't have enough money!");
                                System.out.println(" ");
                            }
                        }
                    } else if (shopWeapons == cnt) {
                        System.out.println("You turned away from the weapon trader!");
                        weapontrader = false;
                    } else {
                        System.out.println("Please enter a valid number!");
                        System.out.println(" ");
                    }
                }
                System.out.println(" ");

            } else if (Shop == 2) {
                System.out.println("There is no Armor trader!");
                System.out.println(" ");
            } else if (Shop == 3) {
                System.out.println("There is no Item trader!");
                System.out.println(" ");
            } else if (Shop == 4) {
                System.out.println("You left the shop!");
                inShop = false;
                village.inVillage();
            } else {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}