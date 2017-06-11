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
                monster.setAttack(rs.getInt("damage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Created a Monster with ID = " + ID);
        return monster;
    }

    public Weapons getWeaponfromID(int ID){
        Weapons weapons = new Weapons();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM Weapons WHERE ID = " + ID);
            while (rs.next()) {
                weapons.setName(rs.getString("name"));
                weapons.setLevel(rs.getInt("level"));
                weapons.setDmgmin(rs.getInt("mindamage"));
                weapons.setDmgmax(rs.getInt("maxdamage"));
                weapons.setHanded(rs.getInt("handed"));
                weapons.setBuyprice(rs.getInt("buyprice"));
                weapons.setSellprice(rs.getInt("sellprice"));
                weapons.setTradable(rs.getInt("tradable"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weapons;
    }

}
