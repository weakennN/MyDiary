package Database;

import Common.HashGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            String hashedPassword = HashGenerator.generateHash(password);
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, hashedPassword);
            statement.setString(5, diaryId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
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
        } finally {
            closeStatement(statement);
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
        } finally {
            closeStatement(statement);
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
        } finally {
            closeStatement(statement);
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
        } finally {
            closeStatement(statement);
        }
    }

    public static boolean isEmailAvailable(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT email FROM accounts WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }

        return true;
    }

    public static boolean isPasswordCorrect(String email, String password) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT password FROM accounts WHERE email = ?";
            String hashedPassword = HashGenerator.generateHash(password);
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (!hashedPassword.equals(resultSet.getString("password"))) {
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }

        return true;
    }

    public static Map<String, List<String>> getAllRegisteredNotes(String diaryId) {
        Map<String, List<String>> notes = new LinkedHashMap<>();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM notes WHERE diary_id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, diaryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                List<String> noteFields = new ArrayList<>();
                noteFields.add(resultSet.getString("title"));
                noteFields.add(resultSet.getString("text"));
                noteFields.add(resultSet.getString("week_day"));
                noteFields.add(resultSet.getInt("month_day") + "");
                noteFields.add(resultSet.getString("month"));
                noteFields.add(resultSet.getInt("year") + "");
                notes.put(resultSet.getString("note_id"), noteFields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }

        return notes;
    }

    public static String getDiaryId(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT diary_id FROM accounts WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("diary_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }

        return null;
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
