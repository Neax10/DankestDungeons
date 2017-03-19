package com.dd.main;

public class Player {
    private String name;
    private int maxhp;
    private int hp;
    private int baseAttack;
    private int lvl;
    private double xp;
    private double nexxp;
    private double prexp;
    private int gold;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static Player instance;

    private Player() {
        InitPlayer();
    }

    public static Player getPlayer() {
        if(instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private void InitPlayer(){
        hp = 100;
        maxhp = 100;
        baseAttack = 10;
        lvl = 1;
        xp = 0;
        nexxp = 100;
        prexp = 0;
        gold = 50;
    }

    public void calcPlayerLevel() {
        xp = xp - nexxp;
        lvl = lvl + 1;
        maxhp = 90 + lvl * 10;
        baseAttack = 9 + lvl;
        hp = hp + 10;
        prexp = nexxp;
        nexxp = prexp * 1.5;
    }
}