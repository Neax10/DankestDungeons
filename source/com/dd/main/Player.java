package com.dd.main;

public class Player {
    private static Player instance;
    private String name;
    private int maxhp;
    private int hp;
    private int baseAttack;
    private int lvl;
    private double xp;
    private double nexxp;
    private double prexp;
    private int gold;

    private Player() {
        InitPlayer();
    }

    private void InitPlayer() {
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

    public static Player getPlayer() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Player getInstance() {
        return instance;
    }

    public static void setInstance(Player instance) {
        Player.instance = instance;
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

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public double getNexxp() {
        return nexxp;
    }

    public void setNexxp(double nexxp) {
        this.nexxp = nexxp;
    }

    public double getPrexp() {
        return prexp;
    }

    public void setPrexp(double prexp) {
        this.prexp = prexp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}