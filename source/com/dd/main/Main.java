package com.dd.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import static com.dd.main.Player.*;

public class Main {
    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();

    public static void main(String[] args) {
        Main m = new Main();
        m.initDatabase();
    }

    public void initDatabase() {
        DBController dbc = DBController.getInstance();
        dbc.initDBConnection();
        initializeGame();
        Monster myMonster = dbc.getMonsterfromID(rand.nextInt(6) + 1);
        String test = myMonster.getName();
        System.out.println("We have a monster with the Name = " + test);
        System.out.println(" ");
        try {
            combatSystem(myMonster);
        } catch (InterruptedException e) {
            //TODO: ERROR HANDLING
            e.printStackTrace();
        }
        //dbc.handleDB();
    }

    public void initializeGame() {


        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        getPlayer().setName(in.nextLine());
        System.out.println("Hello " + getPlayer().getName() + " there are many adventures awaiting you!");
        System.out.println(" ");

    }

    public void combatSystem(Monster monster) throws InterruptedException {
        Player player = getPlayer();
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
                System.out.println(player.getMinBaseAttack() + " - " +  player.getMaxBaseAttack());
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
                    checkPlayerLvl();
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
                        checkPlayerLvl();
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
                healPlayer();
            } else if (cmd == 5) {
                System.out.println("You won!");
                inCombat = false;
                player.setGold(player.getGold() + monster.getGold());
                player.setXp(player.getXp() + monster.getXp());
                System.out.println("You gained " + monster.getGold() + " Gold");
                System.out.println("and " + monster.getXp() + " XP!");
                checkPlayerLvl();
            } else {
                System.out.println("Please enter a valid number!");
            }
            System.out.println(" ");


        }
        inTavern();
    }

    public void Village() {
        Player player = getPlayer();
        System.out.println("Welcome to the Village! What will you do?");
        System.out.println("[1] Go to the tavern!");
        System.out.println("[2] Go shopping!");
        System.out.println("[3] Check the status!");

        int Village = in.nextInt();
        in.nextLine();
        if (Village == 1) {
            inTavern();
            //SHOPPING
        } else if (Village == 2) {
            DBController dbc = DBController.getInstance();
            boolean inShop = true;
            while (inShop) {
                System.out.println("You have " + player.getGold() + " Gold. What do you want to buy?");
                System.out.println("[1] EquippedWeapon");
                System.out.println("[2] Armor");
                System.out.println("[3] Items");
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
                            if (player.getGold() >= shopweapons.getBuyprice()) {
                                //Add weapon to inventory
                                player.setGold(player.getGold() - shopweapons.getBuyprice());
                                System.out.println("You successful bought " + shopweapons.getName() + "!");
                                System.out.println(" ");
                            } else {
                                System.out.println("You don't have enough money!");
                                System.out.println(" ");
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
                    Village();
                } else {
                    System.out.println("Please enter a valid number!");
                }
            }
            System.out.println(" ");

        } else if (Village == 3) {
            Player.EquippedWeapon equippedweapon = player.new EquippedWeapon();
            System.out.println("Hello " + player.getName() + "!");
            System.out.println("You are level " + player.getLvl() + " with " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You have equipped " + equippedweapon.getName() + "!");
            System.out.println("You deal " + player.getMinBaseAttack() + "-" + player.getMaxBaseAttack() + " damage!"); //TODO: attackdamage with additions of weopons etc.
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP!");
            if (player.getHp() < player.getMaxhp()) {
                System.out.println("You can heal your hit points in the tavern!");
            }
            System.out.println("You have " + player.getGold() + " Gold!");
            System.out.println(" ");
            Village();
        } else {
            System.out.println("Please enter a valid number!");
            System.out.println(" ");
            inTavern();
        }
        System.out.println(" ");
    }

    //auswahl tätigen (adventrue, brawl, shopping)
    public void inTavern(){
        Player player = getPlayer();
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
            System.out.println("You start an Adventure!");
            System.out.println(" ");
            //TODO: Delay
            initDatabase();
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
            healPlayer();
            System.out.println(" ");
            inTavern();
        } else if (inTavern == 5) {
            Village();
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

    public void healPlayer(){
        Player player = getPlayer();
        player.setHp(player.getMaxhp());
        System.out.println("You have been healed!");
        System.out.println("You have now " + player.getHp() + "/" + player.getMaxhp() + " HP!");
    }

    public void checkPlayerLvl(){
        Player player = getPlayer();
        if (player.getXp() >= player.getNexxp()) {
            player.calcPlayerLevel();
            System.out.println("Congratulations you reached level " + player.getLvl() + "!");
            System.out.println("For the next level up you have " + player.getXp() + "/" + player.getNexxp() + " XP!");
        } else {
            System.out.println("You have now " + player.getXp() + "/" + player.getNexxp() + " XP!");
        }
        System.out.println(" ");
    }
}
