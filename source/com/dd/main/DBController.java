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
                monster.setGold(rs.getInt("gold"));
                monster.setXp(rs.getInt("xp"));
                monster.setBaseAttack(rs.getInt("damage"));
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

}
