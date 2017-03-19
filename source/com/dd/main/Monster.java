package com.dd.main;

import java.util.Random;

public class Monster {
    private String name;
    private int maxhp;
    private int hp;
    private int lvl;
    private int attack;
    private int gold;
    private int xp;

    public Monster() {
        //Set level for Monster
        Random rng = new Random();
        int rnglvl = rng.nextInt();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
