package com.dd.main;

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
    private int xp;
    private int nexxp;
    private int prexp;
    private int statusPoints;
    private int gold;

    private int strength; //physical damage
    private int intelligence; //magical damage
    private int vitality; //hitpoints
    private int dexterity; //dodge chance
    private int luck; //critical strikes chance



    //Equipment
    //TODO: EquippedWeapon
    public class EquippedWeapon {
        private String name;
        private int level;
        private int dmgmin;
        private int dmgmax;
        private int handed;
        private int buyprice;
        private int sellprice;
        private int tradable;

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

    //TODO: Armor


    private Player() {
        InitPlayer();
    }

    //TODO: Implement weapons and armor
    private void InitPlayer() {
        Player.EquippedWeapon equipweapon = new EquippedWeapon();
        DBController dbc = DBController.getInstance();
        Weapon equippedweapon = dbc.getWeaponfromID(1);

        hp = 100;
        maxhp = 100;
        baseAttack = 10;
        minBaseAttack = (int)(baseAttack * 0.8);
        maxBaseAttack = (int)(baseAttack * 1.2);
        //attack = baseAttack + (EquippedWeapon dmg (max and min));
        lvl = 1;
        xp = 0;
        nexxp = 100;
        prexp = 0;
        gold = 0;


        equipweapon.setName(equippedweapon.getName());
        equipweapon.setLevel(equippedweapon.getLevel());
        equipweapon.setDmgmin(equippedweapon.getDmgmin());
        equipweapon.setDmgmax(equippedweapon.getDmgmax());
        equipweapon.setHanded(equippedweapon.getHanded());
        /*
        equipweapon.setBuyprice(equippedweapon.getBuyprice());
        equipweapon.setSellprice(equippedweapon.getSellprice());
        equipweapon.setTradable(equippedweapon.getTradable());
        */
    }

    public void calcPlayerLevel() {
        xp = xp - nexxp;
        lvl = lvl + 1;
        statusPoints++;
        maxhp = 90 + lvl * 10;
        baseAttack = 9 + lvl;
        minBaseAttack = (int)(baseAttack * 0.8);
        maxBaseAttack = (int)(baseAttack * 1.2);
        hp = hp + 10;
        prexp = nexxp;
        nexxp = (int)(prexp * 1.5);
        calcPlayerDmg();
    }

    public void calcPlayerDmg(){
        Random rand = new Random();
        attack = (int)(rand.nextFloat() * (maxBaseAttack - minBaseAttack + 1) + minBaseAttack);
    }

    public void equipWeapon(){
        //TODO: Inventory connection
        EquippedWeapon equipweapon = new EquippedWeapon();

        /*equipweapon.setName();
        equipweapon.setLevel();
        equipweapon.setDmgmin();
        equipweapon.setDmgmax();
        equipweapon.setHanded();
        equipweapon.setBuyprice();
        equipweapon.setSellprice();
        equipweapon.setTradable();*/
        System.out.println("You equipped " + /*Item from inventory +*/ "!");
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

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getNexxp() {
        return nexxp;
    }

    public void setNexxp(int nexxp) {
        this.nexxp = nexxp;
    }

    public int getPrexp() {
        return prexp;
    }

    public void setPrexp(int prexp) {
        this.prexp = prexp;
    }

    public int getStatusPoints() {
        return statusPoints;
    }

    public void setStatusPoints(int statusPoints) {
        this.statusPoints = statusPoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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
}