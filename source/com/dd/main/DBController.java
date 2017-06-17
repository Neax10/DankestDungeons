package com.dd.main;

import java.sql.*;


public class DBController {

    private static final DBController dbcontroller = new DBController();
    private static final String DB_PATH = "db/dankestdungeons.db";
    private static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Loading JDBC-Driver");
            e.printStackTrace();
        }
    }

    Statement statement;

    private DBController() {
    }

    public static DBController getInstance() {
        return dbcontroller;
    }

    public void initDBConnection() {
        Color color = new Color();
        try {
            if (connection != null)
                return;
            System.out.println(color.getRed() + "Creating Connection to Database..." + color.getDefault());
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            statement = connection.createStatement();
            if (!connection.isClosed())
                System.out.println(color.getRed() + "...Connection established" + color.getDefault());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (!connection.isClosed() && connection != null) {
                    connection.close();
                    if (connection.isClosed())
                        System.out.println("Connection to Database closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }));
    }

    //TODO: What if NULL?!
    public Monster getMonsterfromID(int ID) {
        Monster monster = new Monster();


        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM Monster WHERE ID = " + ID);
            while (rs.next()) {
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("health"));
                monster.setMaxhp(rs.getInt("maxhealth"));
                monster.setBaseAttack(rs.getInt("damage"));
                monster.setGold(rs.getInt("gold"));
                monster.setXp(rs.getInt("xp"));
                monster.setStrength(rs.getInt("strength"));
                monster.setIntelligence(rs.getInt("intelligence"));
                monster.setVitality(rs.getInt("vitality"));
                monster.setDexterity(rs.getInt("dexterity"));
                monster.setLuck(rs.getInt("luck"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Created a Monster with ID = " + ID);
        return monster;
    }

    public Weapon getWeaponfromID(int ID){
        Weapon weapon = new Weapon();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM Weapon WHERE ID = " + ID);
            while (rs.next()) {
                weapon.setId(rs.getInt("id"));
                weapon.setName(rs.getString("name"));
                weapon.setLevel(rs.getInt("level"));
                weapon.setDmgmin(rs.getInt("mindamage"));
                weapon.setDmgmax(rs.getInt("maxdamage"));
                weapon.setHanded(rs.getInt("handed"));
                weapon.setBuyprice(rs.getInt("buyprice"));
                weapon.setSellprice(rs.getInt("sellprice"));
                weapon.setTradable(rs.getInt("tradable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weapon;
    }

    public Item getItemfromID(int ID){
        Item item = new Item();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM Item WHERE ID = " + ID);
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setEffectamount(rs.getInt("effectamount"));
                item.setBuyprice(rs.getInt("buyprice"));
                item.setSellprice(rs.getInt("sellprice"));
                item.setTradable(rs.getInt("tradable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public Bruiser getBruiserfromID(int ID){
        Bruiser bruiser = new Bruiser();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM bruiser WHERE ID = " + ID);
            while (rs.next()) {
                bruiser.setId(rs.getInt("id"));
                bruiser.setName(rs.getString("name"));
                bruiser.setLvl(rs.getInt("level"));
                bruiser.setHp(rs.getInt("health"));
                bruiser.setMaxhp(rs.getInt("maxhealth"));
                bruiser.setBaseAttack(rs.getInt("damage"));
                bruiser.setGold(rs.getInt("gold"));
                bruiser.setXp(rs.getInt("xp"));
                bruiser.setStrength(rs.getInt("strength"));
                bruiser.setIntelligence(rs.getInt("intelligence"));
                bruiser.setVitality(rs.getInt("vitality"));
                bruiser.setDexterity(rs.getInt("dexterity"));
                bruiser.setLuck(rs.getInt("luck"));
                bruiser.setDrunken(rs.getInt("drunken"));
                bruiser.setInjured(rs.getInt("injured"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bruiser;
    }
}
