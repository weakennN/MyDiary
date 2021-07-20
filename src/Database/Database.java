package Database;

import java.sql.*;

public class Database {

    private static final String url = "jdbc:postgresql:MainDatabase";
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

    public static void createUser(int id, String username, String email, String password, int diaryId) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO accounts VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, diaryId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
