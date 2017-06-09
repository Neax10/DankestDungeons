package com.dd.main;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        m.initializeGame();

    }

    public void initDatabase() {
        DBController dbc = DBController.getInstance();
        dbc.initDBConnection();
        Monster myMonster = dbc.getMonsterfromID(1);
        String test = myMonster.getName();
        System.out.println("We have a monster with the Name = " + test);
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
        Player.getPlayer().setName(in.nextLine());
        System.out.println("Hello " + Player.getPlayer().getName() + " there are many adventures awaiting you!");
        initDatabase();
        inTavern();

    }

    public void combatSystem(Monster monster) throws InterruptedException {
        Player player = Player.getPlayer();
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
            //TODO: command input befehl

            int cmd = in.nextInt();
            in.nextLine();
            
            //FIGHT
            if (cmd == 1) {

                //player führt schritt aus
                monster.setHp(monster.getHp() - player.getBaseAttack());
                System.out.println("You did " + player.getBaseAttack() + " damage");
                System.out.println("The " + monster.getName() + " has " + monster.getHp() + "/" + monster.getMaxhp() + " HP left.");
                TimeUnit.SECONDS.sleep(1);

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
                }
                rndCnt++;

                //ITEM
            } else if (cmd == 2) {
                boolean itemuse = false;

                //TODO: ITEMS
                //ITEM used true/false
                if (itemuse == true) {
                    System.out.println("You successfully used " + "item" + "!");
                    System.out.println(" ");
                    //gegner führt schritt aus
                        TimeUnit.SECONDS.sleep(1);

                    player.setHp(player.getHp() - monster.getAttack());
                    System.out.println("The " + monster.getName() + " did " + monster.getAttack() + " damage");
                    System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
                    if (player.getHp() <= 0) {
                        System.out.println("You died!");
                        inCombat = false;
                    } else if (monster.getHp() <= 0) {
                        System.out.println("You won!");
                        inCombat = false;
                    }
                    rndCnt++;

                } else {
                    System.out.println("You didn't use any item!");

                }

                //FLEE
            } else if (cmd == 3) {
                System.out.println("You escaped!");
                inCombat = false;
                inTavern();
            } else {
                System.out.println("Please enter a valid number!");
            }
            System.out.println(" ");


        }
    }
    //auswahl tätigen (adventrue, brawl, shopping)
    public void inTavern(){
        System.out.println("Welcome to the Tavern! What will you do?");
        System.out.println("[1] Go on an adventure!");
        System.out.println("[2] Start a brawl!");
        System.out.println("[3] Go shopping!");

        int inTavern = in.nextInt();
        in.nextLine();

        //ADVENTURE
        if (inTavern == 1) {
            System.out.println("You start an Adventure!");
            //TODO: Delay + flee system
            initDatabase();
            //BRAWL
        } else if (inTavern == 2) {
            //TODO: Brawl system
            System.out.println("There are no opponent's!");
            inTavern();
            //SHOPPING
        } else if (inTavern == 3) {
            //TODO: Shopping system
            System.out.println("There is no trader!");
            inTavern();
        } else {
            System.out.println("Please enter a valid number!");
        }
        System.out.println(" ");
    }
}
