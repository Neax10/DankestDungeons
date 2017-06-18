package com.dd.main;

import java.util.Objects;

public class Inventory {
    //int slot_?[]{typ, id, amount}; typ: 1 weapon, 2 armor, 3 item
    private static Inventory instance;
    private int slot_1[] = {0, 0, 0};
    private int slot_2[] = {0, 0, 0};
    private int slot_3[] = {0, 0, 0};
    private int slot_4[] = {0, 0, 0};
    private int slot_5[] = {0, 0, 0};
    private int slot_6[] = {0, 0, 0};
    private int slot_7[] = {0, 0, 0};
    private int slot_8[] = {0, 0, 0};
    private int slot_9[] = {0, 0, 0};
    private int slot_10[] = {0, 0, 0};

    private static int typweapon = 1;
    private static int typarmor = 2;
    private static int typitem = 3;

    private int selectedslot;

    //0 = empty, 1 = used , 2 = full
    private int inventorystatus = 0;

    private int usesuccsess = 0;

    public static Inventory getInventory() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    //put item in inventory slot
    public void fillSlot(int typ, int id, int amount){
        DBController dbc = DBController.getInstance();
        Item item;
        item = dbc.getItemfromID(id);
        clearEmptySlots();
        if (slot_1[0] <= 0 || slot_1[0] == typ && slot_1[1] == id){
            slot_1[0] = typ;
            slot_1[1] = id;
            slot_1[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_1[2] + "x " + item.getName() + "!");
        } else if (slot_2[0] == 0 || slot_2[0] == typ && slot_2[1] == id){
            slot_2[0] = typ;
            slot_2[1] = id;
            slot_2[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_2[2] + "x " + item.getName() + "!");
        } else if (slot_3[0] <= 0 || slot_3[0] == typ && slot_3[1] == id){
            slot_3[0] = typ;
            slot_3[1] = id;
            slot_3[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_3[2] + "x " + item.getName() + "!");
        } else if (slot_4[0] <= 0 || slot_4[0] == typ && slot_4[1] == id){
            slot_4[0] = typ;
            slot_4[1] = id;
            slot_4[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_4[2] + "x " + item.getName() + "!");
        } else if (slot_5[0] <= 0 || slot_5[0] == typ && slot_5[1] == id){
            slot_5[0] = typ;
            slot_5[1] = id;
            slot_5[1] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_5[2] + "x " + item.getName() + "!");
        } else if (slot_6[0] <= 0 || slot_6[0] == typ && slot_6[1] == id){
            slot_6[0] = typ;
            slot_6[1] = id;
            slot_6[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_6[2] + "x " + item.getName() + "!");
        } else if (slot_7[0] <= 0 || slot_7[0] == typ && slot_7[1] == id){
            slot_7[0] = typ;
            slot_7[1] = id;
            slot_7[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_7[2] + "x " + item.getName() + "!");
        } else if (slot_8[0] <= 0 || slot_8[0] == typ && slot_8[1] == id){
            slot_8[0] = id;
            slot_8[1] = id;
            slot_8[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_8[2] + "x " + item.getName() + "!");
        } else if (slot_9[0] <= 0 || slot_9[0] == typ && slot_9[1] == id){
            slot_9[0] = typ;
            slot_9[1] = id;
            slot_9[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_9[2] + "x " + item.getName() + "!");
        } else if (slot_10[0] <= 0 || slot_10[0] == typ && slot_10[1] == id){
            slot_10[0] = id;
            slot_10[1] = id;
            slot_10[2] += amount;
            if (typ == typitem)
            System.out.println("You have now " + slot_10[2] + "x " + item.getName() + "!");
        } else {
            System.out.println("Your inventory is full!");
        }
        clearEmptySlots();
    }

    //remove from slot
    public void removeItem(int typ, int id, int amount){

        if (slot_1[0] == typ && slot_1[1] == id){
            if (amount <= slot_1[2]) {
                slot_1[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_2[0] == typ && slot_2[1] == id){
            if (amount <= slot_2[2]){
            slot_2[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_3[0] == typ && slot_3[1] == id){
            if (amount <= slot_3[2]){
            slot_3[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_4[0] == typ && slot_4[1] == id){
            if (amount <= slot_4[2]){
            slot_4[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_5[0] == typ && slot_5[1] == id){
            if (amount <= slot_5[2]){
            slot_5[1] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_6[0] == typ && slot_6[1] == id){
            if (amount <= slot_6[2]){
            slot_6[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_7[0] == typ && slot_7[1] == id){
            if (amount <= slot_7[2]){
            slot_7[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_8[0] == typ && slot_8[1] == id){
            if (amount <= slot_8[2]){
            slot_8[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_9[0] == typ && slot_9[1] == id){
            if (amount <= slot_9[2]){
            slot_9[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else if (slot_10[0] == typ && slot_10[1] == id){
            if (amount <= slot_10[2]){
            slot_10[2] -= amount;
                usesuccsess = 1;
            } else {
                usesuccsess = 0;
            }
        } else {
            usesuccsess = 0;
        }
        clearEmptySlots();
    }

    //clear slot
    public void clearSlot(int slot){
        if (slot == 1){
            slot_1[0] = 0;
            slot_1[1] = 0;
            slot_1[2] = 0;
        } else if (slot == 2){
            slot_2[0] = 0;
            slot_2[1] = 0;
            slot_2[2] = 0;
        } else if (slot == 3){
            slot_3[0] = 0;
            slot_3[1] = 0;
            slot_3[2] = 0;
        } else if (slot == 4){
            slot_4[0] = 0;
            slot_4[1] = 0;
            slot_4[2] = 0;
        } else if (slot == 5){
            slot_5[0] = 0;
            slot_5[1] = 0;
            slot_5[2] = 0;
        } else if (slot == 6){
            slot_6[0] = 0;
            slot_6[1] = 0;
            slot_6[2] = 0;
        } else if (slot == 7){
            slot_7[0] = 0;
            slot_7[1] = 0;
            slot_7[2] = 0;
        } else if (slot == 8){
            slot_8[0] = 0;
            slot_8[1] = 0;
            slot_8[2] = 0;
        } else if (slot == 9){
            slot_9[0] = 0;
            slot_9[1] = 0;
            slot_9[2] = 0;
        } else if (slot == 10){
            slot_10[0] = 0;
            slot_10[1] = 0;
            slot_10[2] = 0;
        } else {
            System.out.println("Please enter a valid number!");
        }
    }

    //clear all slots with rest data
    public void clearEmptySlots(){
        if (slot_1[0] <= 0 || slot_1[1] <= 0 || slot_1[2] <= 0){
            slot_1[0] = 0;
            slot_1[1] = 0;
            slot_1[2] = 0;
        }
        if (slot_2[0] <= 0 || slot_2[1] <= 0 || slot_2[2] <= 0){
            slot_2[0] = 0;
            slot_2[1] = 0;
            slot_2[2] = 0;
        }
        if (slot_3[0] <= 0 || slot_3[1] <= 0 || slot_3[2] <= 0){
            slot_3[0] = 0;
            slot_3[1] = 0;
            slot_3[2] = 0;
        }
        if (slot_4[0] <= 0 || slot_4[1] <= 0 || slot_4[2] <= 0){
            slot_4[0] = 0;
            slot_4[1] = 0;
            slot_4[2] = 0;
        }
        if (slot_5[0] <= 0 || slot_5[1] <= 0 || slot_5[2] <= 0){
            slot_5[0] = 0;
            slot_5[1] = 0;
            slot_5[2] = 0;
        }
        if (slot_6[0] <= 0 || slot_6[1] <= 0 || slot_6[2] <= 0){
            slot_6[0] = 0;
            slot_6[1] = 0;
            slot_6[2] = 0;
        }
        if (slot_7[0] <= 0 || slot_7[1] <= 0 || slot_7[2] <= 0){
            slot_7[0] = 0;
            slot_7[1] = 0;
            slot_7[2] = 0;
        }
        if (slot_8[0] <= 0 || slot_8[1] <= 0 || slot_8[2] <= 0){
            slot_8[0] = 0;
            slot_8[1] = 0;
            slot_8[2] = 0;
        }
        if (slot_9[0] <= 0 || slot_9[1] <= 0 || slot_9[2] <= 0){
            slot_9[0] = 0;
            slot_9[1] = 0;
            slot_9[2] = 0;
        }
        if (slot_10[0] <= 0 || slot_10[1] <= 0 || slot_10[2] <= 0){
            slot_10[0] = 0;
            slot_10[1] = 0;
            slot_10[2] = 0;
        }
    }

    //check all slots which items are inside
    public void checkSlots(){
        System.out.println("typ " + slot_1[0] + " id " + slot_1[1] + " amount " + slot_1[2]);
        System.out.println("typ " + slot_2[0] + " id " + slot_2[1] + " amount " + slot_2[2]);
        System.out.println("typ " + slot_3[0] + " id " + slot_3[1] + " amount " + slot_3[2]);
        System.out.println("typ " + slot_4[0] + " id " + slot_4[1] + " amount " + slot_4[2]);
        System.out.println("typ " + slot_5[0] + " id " + slot_5[1] + " amount " + slot_5[2]);
        System.out.println("typ " + slot_6[0] + " id " + slot_6[1] + " amount " + slot_6[2]);
        System.out.println("typ " + slot_7[0] + " id " + slot_7[1] + " amount " + slot_7[2]);
        System.out.println("typ " + slot_8[0] + " id " + slot_8[1] + " amount " + slot_8[2]);
        System.out.println("typ " + slot_9[0] + " id " + slot_9[1] + " amount " + slot_9[2]);
        System.out.println("typ " + slot_10[0] + " id " + slot_10[1] + " amount " + slot_10[2]);
    }

    public void showinventory(int typ, int use){
        Inventory.Healingitems healingitems = new Healingitems();
        DBController dbc = DBController.getInstance();
        Weapon weapon;
        //Armor armor; TODO: ARMOR
        Item item;
        clearEmptySlots();
        if (slot_1[1] >= 1 && typ == slot_1[0]){
            weapon = dbc.getWeaponfromID(slot_1[1]);
            item = dbc.getItemfromID(slot_1[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_1[1] + "] " + slot_1[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_1[1] + "] " + slot_1[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_1[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_1[2] + "x " + item.getName());
            }
        }
        if (slot_2[1] >= 1 && typ == slot_2[0]){
            weapon = dbc.getWeaponfromID(slot_2[1]);
            item = dbc.getItemfromID(slot_2[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_2[1] + "] " + slot_2[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_2[1] + "] " + slot_2[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_2[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_2[2] + "x " + item.getName());
            }
        }
        if (slot_3[1] >= 1 && typ == slot_3[0]){
            weapon = dbc.getWeaponfromID(slot_3[1]);
            item = dbc.getItemfromID(slot_3[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_3[1] + "] " + slot_3[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_3[1] + "] " + slot_3[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_3[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_3[2] + "x " + item.getName());
            }
        }
        if (slot_4[1] >= 1 && typ == slot_4[0]){
            weapon = dbc.getWeaponfromID(slot_4[1]);
            item = dbc.getItemfromID(slot_4[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_4[1] + "] " + slot_4[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_4[1] + "] " + slot_4[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_4[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_4[2] + "x " + item.getName());
            }
        }
        if (slot_5[1] >= 1 && typ == slot_5[0]){
            weapon = dbc.getWeaponfromID(slot_5[1]);
            item = dbc.getItemfromID(slot_5[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_5[1] + "] " + slot_5[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_5[1] + "] " + slot_5[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_5[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_5[2] + "x " + item.getName());
            }
        }
        if (slot_6[1] >= 1 && typ == slot_6[0]){
            weapon = dbc.getWeaponfromID(slot_6[1]);
            item = dbc.getItemfromID(slot_6[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_6[1] + "] " + slot_6[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_6[1] + "] " + slot_6[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_6[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_6[2] + "x " + item.getName());
            }
        }
        if (slot_7[1] >= 1 && typ == slot_7[0]){
            weapon = dbc.getWeaponfromID(slot_7[1]);
            item = dbc.getItemfromID(slot_7[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_7[1] + "] " + slot_7[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_7[1] + "] " + slot_7[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_7[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_7[2] + "x " + item.getName());
            }
        }
        if (slot_8[1] >= 1 && typ == slot_8[0]){
            weapon = dbc.getWeaponfromID(slot_8[1]);
            item = dbc.getItemfromID(slot_8[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_8[1] + "] " + slot_8[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_8[1] + "] " + slot_8[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_8[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_8[2] + "x " + item.getName());
            }
        }
        if (slot_9[1] >= 1 && typ == slot_9[0]){
            weapon = dbc.getWeaponfromID(slot_9[1]);
            item = dbc.getItemfromID(slot_9[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_9[1] + "] " + slot_9[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_9[1] + "] " + slot_9[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_9[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_9[2] + "x " + item.getName());
            }
        }
        if (slot_10[1] >= 1 && typ == slot_10[0]){
            weapon = dbc.getWeaponfromID(slot_10[1]);
            item = dbc.getItemfromID(slot_10[1]);
            if (use == 1) {
                if (typ == typweapon){
                    System.out.println("[" + slot_10[1] + "] " + slot_10[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem) {
                    System.out.println("[" + slot_10[1] + "] " + slot_10[2] + "x " + item.getName());
                    if (Objects.equals(item.getDescription(), "Heal HP"))
                        System.out.println("    Heal " + item.getEffectamount() + "HP!");
                }
            } else {
                if (typ == typweapon) {
                    System.out.println(slot_10[2] + "x " + weapon.getName());
                } else if (typ == typarmor){
                    //TODO: ARMOR
                } else if (typ == typitem)
                    System.out.println(slot_10[2] + "x " + item.getName());
            }
        }
        if (slot_1[1] == 0 && slot_2[1] == 0 && slot_3[1] == 0 && slot_4[1] == 0 && slot_5[1] == 0 && slot_6[1] == 0 && slot_7[1] == 0 && slot_8[1] == 0 && slot_9[1] == 0 && slot_10[1] == 0 ){
            setInventorystatus(0);
        }
        System.out.println("");
    }

    //not in use
    public class Healingitems {
        private int id;
        private String name;
        private String description;
        private int effectamount;
        private int buyprice;
        private int sellprice;
        private int tradable;

        public Healingitems(){

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getEffectamount() {
            return effectamount;
        }

        public void setEffectamount(int effectamount) {
            this.effectamount = effectamount;
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
        int[] healingitems = {};

    }

    public int[] getSlot_1() {
        return slot_1;
    }

    public void setSlot_1(int[] slot_1) {
        this.slot_1 = slot_1;
    }

    public int[] getSlot_2() {
        return slot_2;
    }

    public void setSlot_2(int[] slot_2) {
        this.slot_2 = slot_2;
    }

    public int[] getSlot_3() {
        return slot_3;
    }

    public void setSlot_3(int[] slot_3) {
        this.slot_3 = slot_3;
    }

    public int[] getSlot_4() {
        return slot_4;
    }

    public void setSlot_4(int[] slot_4) {
        this.slot_4 = slot_4;
    }

    public int[] getSlot_5() {
        return slot_5;
    }

    public void setSlot_5(int[] slot_5) {
        this.slot_5 = slot_5;
    }

    public int[] getSlot_6() {
        return slot_6;
    }

    public void setSlot_6(int[] slot_6) {
        this.slot_6 = slot_6;
    }

    public int[] getSlot_7() {
        return slot_7;
    }

    public void setSlot_7(int[] slot_7) {
        this.slot_7 = slot_7;
    }

    public int[] getSlot_8() {
        return slot_8;
    }

    public void setSlot_8(int[] slot_8) {
        this.slot_8 = slot_8;
    }

    public int[] getSlot_9() {
        return slot_9;
    }

    public void setSlot_9(int[] slot_9) {
        this.slot_9 = slot_9;
    }

    public int[] getSlot_10() {
        return slot_10;
    }

    public void setSlot_10(int[] slot_10) {
        this.slot_10 = slot_10;
    }

    public int getSelectedslot() {
        return selectedslot;
    }

    public void setSelectedslot(int selectedslot) {
        this.selectedslot = selectedslot;
    }

    public int getTypweapon() {
        return typweapon;
    }

    public void setTypweapon(int typweapon) {
        this.typweapon = typweapon;
    }

    public int getTyparmor() {
        return typarmor;
    }

    public void setTyparmor(int typarmor) {
        this.typarmor = typarmor;
    }

    public int getTypitem() {
        return typitem;
    }

    public void setTypitem(int typitem) {
        this.typitem = typitem;
    }

    public int getInventorystatus() {
        return inventorystatus;
    }

    public void setInventorystatus(int inventorystatus) {
        this.inventorystatus = inventorystatus;
    }

    public int getUsesuccsess() {
        return usesuccsess;
    }

    public void setUsesuccsess(int usesuccsess) {
        this.usesuccsess = usesuccsess;
    }
}