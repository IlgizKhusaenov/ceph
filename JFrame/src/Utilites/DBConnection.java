package Utilites;

import exceptions.DBException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String DRIVER = "java.sql.Driver";
    private final static String CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/mydbgui";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "godlikeinside";

    private static Connection connection;

    public static Connection getDBConnection() throws DBException {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new DBException("Can't find DB driver...");
            } catch (SQLException ex) {
                throw new DBException("Can't connect to DB (" + ex.getErrorCode() + ":" + ex.getMessage() + ")");

            }
        }
        return connection;
    }
}
