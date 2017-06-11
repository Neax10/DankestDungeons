package com.dd.main;

import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class Player {
    private static Player instance;
    private String name;
    private int maxhp;
    private int hp;
    private int baseAttack;
    private int minBaseAttack;
    private int maxBaseAttack;
    private int attack; //damage values together
    private int lvl;
    private double xp;
    private double nexxp;
    private double prexp;
    private int gold;

    //Equipment
    //TODO: Weapons

    //TODO: Armor


    private Player() {
        InitPlayer();
    }

    //TODO: Implement weapons and armor
    private void InitPlayer() {
        //Weapons weapons = Weapons.getWeapons();
        hp = 100;
        maxhp = 100;
        baseAttack = 10;
        //minBaseAttack = baseAttack * 0.8;
        //maxBaseAttack = baseAttack * 1.2;
        //attack = baseAttack + (Weapon dmg (max and min));
        lvl = 1;
        xp = 0;
        nexxp = 100;
        prexp = 0;
        gold = 0;
        calcPlayerDmg();
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

    //TODO: Player damage calculator
    public void calcPlayerDmg(){
        minBaseAttack = baseAttack;
        maxBaseAttack = baseAttack;
        if (baseAttack >= 10){
            minBaseAttack = baseAttack - 2;
            maxBaseAttack = baseAttack + 2;
            if (baseAttack >= 100){
                minBaseAttack = baseAttack - 20;
                maxBaseAttack = baseAttack + 20;
                if (baseAttack >= 1000){
                    minBaseAttack = baseAttack - 200;
                    maxBaseAttack = baseAttack + 200;
                    if (baseAttack >= 10000){
                        minBaseAttack = baseAttack - 2000;
                        maxBaseAttack = baseAttack + 2000;
                    }
                }
            }
        }

        attack = (int)(Math.random() * (maxBaseAttack - minBaseAttack + 1)) + minBaseAttack;
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

    public int getMinBaseAttack() {
        return minBaseAttack;
    }

    public void setMinBaseAttack(int minBaseAttack) {
        this.minBaseAttack = minBaseAttack;
    }

    public int getMaxBaseAttack() {
        return maxBaseAttack;
    }

    public void setMaxBaseAttack(int maxBaseAttack) {
        this.maxBaseAttack = maxBaseAttack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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