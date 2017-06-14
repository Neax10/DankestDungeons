package com.dd.main;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private static Player instance;
    private String name;
    private int maxhp;
    private int hp;
    private int baseAttack;
    private int minBaseAttack;
    private int maxBaseAttack;
    private int attack; //damage values together
    private int dodge;
    private int crit;
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

    private int maxstamina;
    private int stamina;
    private int maxmana;
    private int mana;

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

        //Points per level = 10
        strength = 10; //1 dmg = 5 Str
        intelligence = 10; //1 mag.dmg = 5 Int
        vitality = 10; //2 hp = 1 Vit
        dexterity = 10; //1% dodge 10 Dex
        luck = 10; //1% crit = 10 Luc

        hp = 80 + vitality * 2;
        maxhp = 80 + vitality * 2;
        lvl = 1;
        xp = 0;
        nexxp = 100;
        prexp = 0;
        gold = 0;
        calcPlayerStats();

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

    public void checkPlayerLvl(){
        Player player = Player.getPlayer();
        if (player.getXp() >= player.getNexxp()) {
            player.calcPlayerLevel();
            System.out.println("Congratulations you reached level " + player.getLvl() + "!");
            System.out.println("For the next level up you have " + player.getXp() + "/" + player.getNexxp() + " XP!");
            System.out.println("You got 10 status points. Now you have " + player.getStatusPoints() + " status points");
        } else {
            System.out.println("You have now " + player.getXp() + "/" + player.getNexxp() + " XP!");
        }
        System.out.println(" ");
    }

    public void calcPlayerLevel() {
        Player.EquippedWeapon equippedWeapon = new EquippedWeapon();

        xp = xp - nexxp;
        lvl = lvl + 1;
        maxhp = 80 + vitality * 2;
        baseAttack = 9 + lvl;
        minBaseAttack = (int)(baseAttack * 0.8) + equippedWeapon.getDmgmin();
        maxBaseAttack = (int)(baseAttack * 1.2) + equippedWeapon.getDmgmax();
        prexp = nexxp;
        nexxp = (int)(prexp * 1.25);
        statusPoints += 10;
        calcPlayerStats();
        hp = maxhp;
        stamina = maxstamina;
        mana = maxmana;
    }

    public void calcPlayerStats(){
        Random rand = new Random();
        Player.EquippedWeapon equippedWeapon = new EquippedWeapon();

        maxhp = 80 + vitality * 2;
        if (strength >= dexterity){
            maxstamina = dexterity * 2;
        } else if (strength <= dexterity){
            maxstamina = strength * 2;
        } else {
            System.out.println("ERROR: stat.calc.fail");
        }
        maxmana = intelligence;
        baseAttack = 8 + strength / 5;
        minBaseAttack = (int)(baseAttack * 0.8) + equippedWeapon.getDmgmin();
        maxBaseAttack = (int)(baseAttack * 1.2) + equippedWeapon.getDmgmax();
        attack = (int)(rand.nextFloat() * (maxBaseAttack - minBaseAttack + 1) + minBaseAttack);
        dodge = dexterity / 10;
        crit = luck / 10;
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

    public void drinkABeer(){
        Scanner in = new Scanner(System.in);
        Player player = getPlayer();

        System.out.println("1 beer costs 10 gold and regenerate 10 HP!");
        System.out.println("How much beer do you want?");

        int beer = in.nextInt();
        in.nextLine();

        if (gold >= beer * 10) {
            setGold(getGold() - beer * 10);
            setHp(getHp() + beer * 10);
            if (getHp() > getMaxhp()){
                setHp(getMaxhp());
            }
            System.out.println("You drunk " + beer + " beer, payed " + beer * 10 + " gold and regenerated " + beer * 10 + " HP!");
            System.out.println("You have now " + player.getHp() + "/" + player.getMaxhp() + " HP!");
        } else if (gold < beer * 10){
            System.out.println("You don't have enough money!");
        } else {
            System.out.println("Please enter a valid number!");
        }
    }

    public void devHealPlayer(){
        Player player = getPlayer();
        player.setHp(player.getMaxhp());
        System.out.println("You have been healed!");
        System.out.println("You have now " + player.getHp() + "/" + player.getMaxhp() + " HP!");
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

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
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

    public int getMaxstamina() {
        return maxstamina;
    }

    public void setMaxstamina(int maxstamina) {
        this.maxstamina = maxstamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMaxmana() {
        return maxmana;
    }

    public void setMaxmana(int maxmana) {
        this.maxmana = maxmana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    /**================================================Status points=================================================**/

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