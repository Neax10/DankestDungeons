package com.dd.main;

public class Weapon {
    private String name;
    private int level;
    private int dmgmin;
    private int dmgmax;
    private int handed;
    private int buyprice;
    private int sellprice;
    private int tradable;

    /*public static EquippedWeapon getWeapons(){

    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDmgmin() {
        return dmgmin;
    }

    public void setDmgmin(int dmgmin) {
        this.dmgmin = dmgmin;
    }

    public int getDmgmax() {
        return dmgmax;
    }

    public void setDmgmax(int dmgmax) {
        this.dmgmax = dmgmax;
    }

    public int getHanded() {
        return handed;
    }

    public void setHanded(int handed) {
        this.handed = handed;
    }

    public int getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(int buyprice) {
        this.buyprice = buyprice;
    }

    public int getSellprice() {
        return sellprice;
    }

    public void setSellprice(int sellprice) {
        this.sellprice = sellprice;
    }

    public int getTradable() {
        return tradable;
    }

    public void setTradable(int tradable) {
        this.tradable = tradable;
    }
}
