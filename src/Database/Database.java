package Database;

import java.sql.*;

public class Database {

    private static final String url = "jdbc:postgresql://localhost:5432/MainDatabase";
    private static final String username = "postgres";
    private static final String password = "ROOT";
    private static Connection connection;

    public static void makeConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
