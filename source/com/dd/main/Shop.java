package com.dd.main;

import java.util.Scanner;

public class Shop {

    public void Shop() {
        DBController dbc = DBController.getInstance();
        Scanner in = new Scanner(System.in);
        Player player = Player.getPlayer();
        Player.EquippedWeapon equipweapon = player.new EquippedWeapon();
        Inventory inventory = Inventory.getInventory();
        Inventory.Healingitems healingitems = inventory.new Healingitems();
        Village village = new Village();

        boolean inShop = true;
        while (inShop) {
            System.out.println("You have " + player.getGold() + " Gold. What do you want to buy?");
            System.out.println("[1] Weapon");
            System.out.println("[2] Armor");
            System.out.println("[3] Item");
            System.out.println("[4] Leave Shop");

            int Shop = in.nextInt();
            in.nextLine();

            //WEAPONTRADER
            if (Shop == 1) {
                boolean weapontrader = true;
                while (weapontrader) {
                    System.out.println("Weapons: ");
                    int cnt;
                    int itm = 1;
                    for (cnt = 1; cnt <= 11; cnt++) {
                        Weapon shopweapon = dbc.getWeaponfromID(cnt);
                        if (shopweapon.getTradable() == 1) {
                            System.out.println("[" + cnt + "] " + shopweapon.getName() + ", level " + shopweapon.getLevel() + ", " + shopweapon.getDmgmin() + "-" + shopweapon.getDmgmax() + " damage, " + shopweapon.getHanded() + " Handed, price: " + shopweapon.getBuyprice() + " Gold");
                            itm++;
                        }
                    }
                    System.out.println(" ");
                    System.out.println("[" + cnt + "] Leave weapon trader");

                    int shopWeapons = in.nextInt();
                    in.nextLine();

                    //check weapon id
                    Weapon shopweapons = dbc.getWeaponfromID(shopWeapons);
                    if (shopweapons.getTradable() == 1) {
                        if (shopweapons.getLevel() > player.getLvl()) {
                            System.out.println("Your level is to low for this weapon!");
                            System.out.println(" ");
                        } else {
                            if (player.getGold() >= shopweapons.getBuyprice()) {
                                //equip weapon TODO: add to inventory
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

                //ARMORTRADER
            } else if (Shop == 2) {
                System.out.println("There is no Armor trader!");
                System.out.println(" ");

                //ITEMTRADER
            } else if (Shop == 3) {
                boolean itemtrader = true;
                while (itemtrader) {
                    System.out.println("Items: ");
                    int cnt;
                    int itm = 1;
                    for (cnt = 1; cnt <= 3; cnt++) {
                        Item shopitem = dbc.getItemfromID(cnt);
                        if (shopitem.getTradable() == 1) {
                            System.out.println("[" + cnt + "] " + shopitem.getName() + ", heal " + shopitem.getEffectamount() + " HP, price: " + shopitem.getBuyprice() + " Gold");
                            itm++;
                        }
                    }
                    System.out.println(" ");
                    System.out.println("[" + cnt + "] Leave weapon trader");

                    int shopItems = in.nextInt();
                    in.nextLine();

                    //check weapon id
                    Item shopitem = dbc.getItemfromID(shopItems);
                    //Test item line!!! System.out.println("You want to buy " + shopweapons.getName() + "!");
                    if (shopitem.getTradable() == 1 && player.getGold() > shopitem.getBuyprice()) {
                        System.out.println("How much " + shopitem.getName() + "s do you want to buy?");
                        int amount = in.nextInt();
                        in.nextLine();

                        if (player.getGold() >= shopitem.getBuyprice() * amount) {
                            //Add item to inventory
                            player.setGold(player.getGold() - shopitem.getBuyprice() * amount);

                            inventory.fillSlot(inventory.getTypitem(), shopitem.getId(), amount);

                            System.out.println("You bought " + amount + " " + shopitem.getName() + "/s!");
                            System.out.println(" ");
                        } else {
                            System.out.println("You don't have enough money!");
                            System.out.println(" ");
                        }
                    } else if (shopItems == cnt) {
                        System.out.println("You turned away from the item trader!");
                        itemtrader = false;
                    } else if (player.getGold() <= shopitem.getBuyprice()){
                        System.out.println("You don't have enough money!");
                        System.out.println(" ");
                    } else {
                        System.out.println("Please enter a valid number!");
                        System.out.println(" ");
                    }
                }
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