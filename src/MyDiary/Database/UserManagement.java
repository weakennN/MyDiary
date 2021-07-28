package MyDiary.Database;

import MyDiary.Common.HashGenerator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserManagement {

    public static void createUser(String username, String email, String password) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO accounts(user_name,email,password) VALUES (?, ?, ?)";
            String hashedPassword = HashGenerator.generateHash(password);
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }
    }

    public static boolean isUsernameAvailable(String username) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT user_name FROM accounts WHERE user_name = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return true;
    }

    public static boolean isEmailAvailable(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT email FROM accounts WHERE email = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return true;
    }

    public static boolean isPasswordCorrect(String email, String password) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT password FROM accounts WHERE email = ?";
            String hashedPassword = HashGenerator.generateHash(password);
            statement = Database.getConnection().prepareStatement(query);
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
            Database.closeStatement(statement);
        }

        return true;
    }

    public static int getUserId(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id FROM accounts WHERE email = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return 0;
    }
}
