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
        combatSystem(myMonster);
        //dbc.handleDB();
    }

    public void initializeGame() {
        initDatabase();
        System.out.println("Welcome to DankestDungeons");
        System.out.println("Please type in your Player name:");
        Player.getPlayer().setName(in.nextLine());
        System.out.println("Hello " + Player.getPlayer().getName() + " there are many adventures awaiting you!");

    }

    public void combatSystem(Monster monster) {
        Player player = Player.getPlayer();
        boolean inCombat = true;
        int rndCnt = 1;
        //monster erscheint
        System.out.println("A wild " + monster.getName() + " appeared!");
        System.out.println("A " + monster.getName() + " wants to fight against you!");
        while (inCombat) {

            //auswahl tätigen (kämpfen, item, flüchten)
            System.out.println("TURN " + rndCnt + ". What will you do?");
            System.out.println("1 FIGHT");
            System.out.println("2 ITEM");
            System.out.println("3 FLEE");
            //TODO: command input befehl
            in.nextLine();

            //player führt schritt aus
            monster.setHp(monster.getHp() - player.getBaseAttack());
            System.out.println("You did " + player.getBaseAttack() + " damage");
            System.out.println("The " + monster.getName() + " has " + monster.getHp() + "/" + monster.getMaxhp() + " HP left.");
            //gegner führt schritt aus
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                //TODO: Error Handling
                e.printStackTrace();
            }
            player.setHp(player.getHp() - monster.getAttack());
            System.out.println("The " + monster.getName() + " did " + monster.getAttack() + " damage");
            System.out.println("You have " + player.getHp() + "/" + player.getMaxhp() + " HP left.");
            if (player.getHp() <= 0) {
                System.out.println("You died!");
                inCombat = false;
            } else if (monster.getHp() <= 0){
                System.out.println("You won!");
                inCombat = false;
            }
            rndCnt++;
        }
    }
}

