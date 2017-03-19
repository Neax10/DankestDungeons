package com.dd.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBController {

    private static final DBController dbcontroller = new DBController();
    private static final String DB_PATH = "db/dankestdungeons.db";
    private static Connection connection;
    Statement statement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Loading JDBC-Driver");
            e.printStackTrace();
        }
    }

    private DBController() {
    }

    public static DBController getInstance() {
        return dbcontroller;
    }

    public void initDBConnection() {
        try {
            if (connection != null)
                return;
            System.out.println("Creating Connection to Database...");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            statement = connection.createStatement();
            if (!connection.isClosed())
                System.out.println("...Connection established");
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
            while(rs.next()) {
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

}
