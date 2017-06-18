package com.dd.main;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CombatSystem {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    Color color = new Color();
    public boolean inCombat;

    public void combatSystem(Monster monster) throws InterruptedException {
        DBController dbc = DBController.getInstance();
        Inventory inv = Inventory.getInventory();
        Item item;
        Player player = Player.getPlayer();
        Tavern tavern = new Tavern();


        inCombat = true;
        int rndCnt = 1;
        //monster erscheint
        monster.monsterStats();
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
                    System.out.println(" ");
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
                boolean itemuse = true;

                if (itemuse) {
                    if (inv.getInventorystatus() >= 1) {
                        System.out.println("Which item do you want to use?");
                        inv.showinventory(3, 1);
                        System.out.println("[0] nothing!");
                        int itm = in.nextInt();
                        in.nextLine();

                        item = dbc.getItemfromID(itm);
                        inv.removeItem(3, itm, 1);
                        if (item.getUsable() == 1 && inv.getUsesuccsess() == 1) {
                            player.setHp(player.getHp() + item.getEffectamount());
                            if (player.getHp() > player.getMaxhp())
                                player.setHp(player.getMaxhp());
                            System.out.println("You successfully used " + item.getName() + "!");
                            if (Objects.equals(item.getDescription(), "Heal HP"))
                                System.out.println("You have now " + player.getHp() + "/" + player.getMaxhp() + "HP!");
                            System.out.println(" ");

                            //gegner führt schritt aus
                            int dodgec = (int)(rand.nextFloat() * 100 + 1);

                            if (player.getDodge() >= dodgec) {
                                System.out.println("You dodged the attack!");
                                System.out.println(" ");
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
                        } else if (itm == 0){

                        } else {
                            System.out.println("Please enter a valid number!");
                        }
                    } else if (inv.getInventorystatus() == 0) {
                        System.out.println("You have no usable items!");
                    } else {
                        System.out.println("ERROR: inv.stat.unknown!");
                    }

                } else {
                    System.out.println("You can't use any item!");
                }

                //FLEE
            } else if (cmd == 3) {
                System.out.println("You escaped!");
                inCombat = false;
                tavern.inTavern();
            } else if (cmd == 98) {
                player.devHealPlayer();
            } else if (cmd == 99) {
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

/**===================================================================================================================*/
/**==================================================BruiserCombatSystem==============================================*/
/**===================================================================================================================*/

    public void combatSystem(Bruiser bruiser) throws InterruptedException {
        DBController dbc = DBController.getInstance();
        Inventory inv = Inventory.getInventory();
        Item item;
        Player player = Player.getPlayer();
        Tavern tavern = new Tavern();


        inCombat = true;
        int rndCnt = 1;
        //monster erscheint
        bruiser.bruiserStats();
        bruiser.bruiserCheckStats();
        System.out.println("A " + bruiser.getName() + " level " + bruiser.getLvl() + " is ready to fight against you!");
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
                bruiser.bruiserCheckStats();
                System.out.println(player.getMinBaseAttack() + " - " + player.getMaxBaseAttack());
                //player führt schritt aus
                int critc = (int)(rand.nextFloat() * 100 + 1);

                if (player.getCrit() >= critc){
                    bruiser.setHp(bruiser.getHp() - player.getAttack() * 2);
                    System.out.println("Critical strike!");
                    System.out.println("You did " + player.getAttack() * 2 + " damage.");
                    System.out.println("The " + bruiser.getName() + " has " + bruiser.getHp() + "/" + bruiser.getMaxhp() + " HP left.");
                } else {
                    bruiser.setHp(bruiser.getHp() - player.getAttack());
                    System.out.println("You did " + player.getAttack() + " damage.");
                    System.out.println("The " + bruiser.getName() + " has " + bruiser.getHp() + "/" + bruiser.getMaxhp() + " HP left.");
                }

                System.out.println(" ");

                //gegner führt schritt aus
                int dodgec = (int)(rand.nextFloat() * 100 + 1);

                if (player.getDodge() >= dodgec) {
                    System.out.println("You dodged the attack!");
                    System.out.println(" ");
                } else {
                    player.setHp(player.getHp() - bruiser.getAttack());
                    System.out.println("The " + bruiser.getName() + " did " + bruiser.getAttack() + " damage.");
                    System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                }
                TimeUnit.SECONDS.sleep(1);

                if (player.getHp() <= 0) {
                    System.out.println("You died!");
                    inCombat = false;

                } else if (bruiser.getHp() <= 0) {
                    System.out.println("You won!");
                    inCombat = false;
                    player.setGold(player.getGold() + bruiser.getGold());
                    player.setXp(player.getXp() + bruiser.getXp());
                    System.out.println("You gained " + bruiser.getGold() + " Gold");
                    System.out.println("and " + bruiser.getXp() + " XP!");
                    player.setNextbruiserid(player.getNextbruiserid() + 1);
                    player.checkPlayerLvl();
                }
                rndCnt++;

                //ITEM
            } else if (cmd == 2) {
                boolean itemuse = true;

                if (itemuse) {
                    if (inv.getInventorystatus() >= 1) {
                        System.out.println("Which item do you want to use?");
                        inv.showinventory(3, 1);
                        System.out.println("[0] nothing!");
                        int itm = in.nextInt();
                        in.nextLine();

                        item = dbc.getItemfromID(itm);
                        inv.removeItem(3, itm, 1);
                        if (item.getUsable() == 1 && inv.getUsesuccsess() == 1) {
                            player.setHp(player.getHp() + item.getEffectamount());
                            if (player.getHp() > player.getMaxhp())
                                player.setHp(player.getMaxhp());
                            System.out.println("You successfully used " + item.getName() + "!");
                            if (Objects.equals(item.getDescription(), "Heal HP"))
                                System.out.println("You have now " + player.getHp() + "/" + player.getMaxhp() + "HP!");
                            System.out.println(" ");

                            //gegner führt schritt aus
                            int dodgec = (int)(rand.nextFloat() * 100 + 1);

                            if (player.getDodge() >= dodgec) {
                                System.out.println("You dodged the attack!");
                                System.out.println(" ");
                            } else {
                                player.setHp(player.getHp() - bruiser.getAttack());
                                System.out.println("The " + bruiser.getName() + " did " + bruiser.getAttack() + " damage.");
                                System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                            }
                            TimeUnit.SECONDS.sleep(1);
                            if (player.getHp() <= 0) {
                                System.out.println("You died!");
                                inCombat = false;
                            } else if (bruiser.getHp() <= 0) {
                                System.out.println("You won!");
                                inCombat = false;
                                player.setGold(player.getGold() + bruiser.getGold());
                                player.setXp(player.getXp() + bruiser.getXp());
                                System.out.println("You gained " + bruiser.getGold() + " Gold");
                                System.out.println("and " + bruiser.getXp() + " XP!");
                                player.checkPlayerLvl();
                            }
                            rndCnt++;
                        } else if (itm == 0){

                        } else {
                            System.out.println("Please enter a valid number!");
                        }
                    } else if (inv.getInventorystatus() == 0) {
                        System.out.println("You have no usable items!");
                    } else {
                        System.out.println("ERROR: inv.stat.unknown!");
                    }

                } else {
                    System.out.println("You can't use any item!");
                }

                //FLEE
            } else if (cmd == 3) {
                System.out.println("You can't escape from a brawl");
            } else if (cmd == 98) {
                player.devHealPlayer();
            } else if (cmd == 99) {
                System.out.println("You won!");
                inCombat = false;
                player.setGold(player.getGold() + bruiser.getGold());
                player.setXp(player.getXp() + bruiser.getXp());
                System.out.println("You gained " + bruiser.getGold() + " Gold");
                System.out.println("and " + bruiser.getXp() + " XP!");
                player.checkPlayerLvl();
            } else {
                System.out.println("Please enter a valid number!");
            }
            System.out.println(" ");


        }
        tavern.inTavern();
    }
}