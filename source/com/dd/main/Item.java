package com.dd.main;

public class Item {
    private int id;
    private String name;
    private String description;
    private int effectamount;
    private int buyprice;
    private int sellprice;
    private int tradable;
    private int usable;

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

    public void setEffectamount(int amout) {
        this.effectamount = amout;
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

    public int getUsable() {
        return usable;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }
}
