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

    public static void createUser(String id, String username, String email, String password, String diaryId) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO accounts VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, diaryId);
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

    public static void registerNote(String noteId, String diaryId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO notes VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, noteId);
            statement.setString(2, diaryId);
            statement.setString(3, title);
            statement.setString(4, text);
            statement.setString(5, weekDay);
            statement.setInt(6, monthDay);
            statement.setString(7, month);
            statement.setInt(8, year);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editNote(String noteId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE notes SET title = ?, text = ?, week_day = ?, month_day = ? , month = ?, year = ? WHERE note_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.setString(2, text);
            statement.setString(3, weekDay);
            statement.setInt(4, monthDay);
            statement.setString(5, month);
            statement.setInt(6, year);
            statement.setString(7, noteId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isUsernameAvailable(String username) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT user_name FROM accounts WHERE user_name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void removeNote(String noteId) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM notes WHERE note_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, noteId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
