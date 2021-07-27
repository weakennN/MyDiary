package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiaryManagement {

    public static void registerNote(String noteId, String diaryId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO notes VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = Database.getConnection().prepareStatement(query);
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
            Database.closeStatement(statement);
        }
    }

    public static void editNote(String noteId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE notes SET title = ?, text = ?, week_day = ?, month_day = ? , month = ?, year = ? WHERE note_id = ?";
            statement = Database.getConnection().prepareStatement(query);
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
            Database.closeStatement(statement);
        }
    }

    public static void removeNote(String noteId) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM notes WHERE note_id = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, noteId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }
    }

    public static Map<String, List<String>> getAllRegisteredNotes(String diaryId) {
        Map<String, List<String>> notes = new LinkedHashMap<>();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM notes WHERE diary_id = ?";
            statement = Database.getConnection().prepareStatement(query);
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
            Database.closeStatement(statement);
        }

        return notes;
    }

    public static String getDiaryId(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT diary_id FROM accounts WHERE email = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("diary_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return null;
    }

    public static List<String> getNoteIds(String criteria, String diaryId) {
        List<String> ids = new ArrayList<>();
        PreparedStatement statement = null;

        try {
            criteria = "%" + criteria + "%";
            String query = "SELECT note_id FROM notes WHERE (title ILIKE ? OR text ILIKE ? OR week_day ILIKE ? OR cast(month_day AS VARCHAR) ILIKE ? " +
                    "OR month ILIKE ? OR cast(year AS VARCHAR) ILIKE ?) AND diary_id = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, criteria);
            statement.setString(2, criteria);
            statement.setString(3, criteria);
            statement.setString(4, criteria);
            statement.setString(5, criteria);
            statement.setString(6, criteria);
            statement.setString(7, diaryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ids.add(resultSet.getString("note_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return ids;
    }
}
