package com.dd.main;


public class Player {


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int hitpoints;
    private int maxHitpoints;
    private int attack;
    private int gold;
    private int xp;

    public Player() {

    }
}
