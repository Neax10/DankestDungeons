package com.dd.main;

import java.util.Random;

public class Bruiser {
    private int id;
    private String name;
    private int maxhp;
    private int hp;
    private int baseAttack;
    private int minBaseAttack;
    private int maxBaseAttack;
    private int attack;
    private int dodge;
    private int crit;
    private int lvl;
    private int xp;
    private int gold;

    private int strength; //physical damage
    private int intelligence; //magical damage
    private int vitality; //hitpoints
    private int dexterity; //dodge chance
    private int luck; //critical strikes chance

    private int stamina;
    private int mana;

    private int drunken;
    private int injured;

    public Bruiser(){

    }

    public void bruiserStats(){
        Random rand = new Random();

        if (drunken == 1 || injured == 1){
            name = name + " (";
        }
        if (drunken == 1){
            name =  name + "drunken";
        }
        if (drunken == 1 && injured == 1){
            name = name + " & ";
        }
        if (injured == 1){
            name = name + "injured";
        }
        if (drunken == 1 || injured == 1){
            name = name + ")";
        }

        maxhp = maxhp + vitality * 2;
        if (injured == 1) {
            hp = (int)(maxhp * 0.6);
        } else {
            hp = maxhp;
        }
        baseAttack = baseAttack + strength / 5;
    }

    public void bruiserCheckStats(){
        Random rand = new Random();

        minBaseAttack = (int)(baseAttack * 0.8);
        maxBaseAttack = (int)(baseAttack * 1.2);
        attack = (int)(rand.nextFloat() * (maxBaseAttack - minBaseAttack + 1) + minBaseAttack);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDrunken() {
        return drunken;
    }

    public void setDrunken(int drunken) {
        this.drunken = drunken;
    }

    public int getInjured() {
        return injured;
    }

    public void setInjured(int injured) {
        this.injured = injured;
    }
}
