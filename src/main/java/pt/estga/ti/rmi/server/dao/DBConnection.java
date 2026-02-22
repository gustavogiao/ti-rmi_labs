package pt.estga.ti.rmi.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:school.db";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL);
    }
}
