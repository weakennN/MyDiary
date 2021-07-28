package MyDiary.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiaryManagement {

    public static void registerNote(int diaryId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO notes(diary_id,title,text,week_day,month_day,month,year) VALUES(?, ?, ?, ?, ?, ?, ?)";
            statement = getNoteStatement(query, diaryId, title, text, weekDay, monthDay, month, year);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }
    }

    public static void editNote(int noteId, String title, String text, String weekDay, int monthDay, String month, int year) {
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
            statement.setInt(7, noteId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }
    }

    public static void removeNote(int noteId) {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM notes WHERE note_id = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, noteId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }
    }

    public static Map<Integer, List<String>> getAllRegisteredNotes(int diaryId) {
        Map<Integer, List<String>> notes = new LinkedHashMap<>();
        PreparedStatement statement = null;
        try {
            String query = "SELECT * FROM notes WHERE diary_id = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, diaryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                List<String> noteFields = new ArrayList<>();
                noteFields.add(resultSet.getString("title"));
                noteFields.add(resultSet.getString("text"));
                noteFields.add(resultSet.getString("week_day"));
                noteFields.add(resultSet.getInt("month_day") + "");
                noteFields.add(resultSet.getString("month"));
                noteFields.add(resultSet.getInt("year") + "");
                notes.put(resultSet.getInt("note_id"), noteFields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return notes;
    }

    public static int getDiaryId(String email) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT diary_id FROM accounts WHERE email = ?";
            statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("diary_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return 0;
    }

    public static List<Integer> getNoteIds(String criteria, int diaryId) {
        List<Integer> ids = new ArrayList<>();
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
            statement.setInt(7, diaryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ids.add(resultSet.getInt("note_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return ids;
    }

    public static int getNoteId(int diaryId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement = null;
        try {
            String query = "SELECT note_id FROM notes WHERE diary_id = ? AND title = ? AND text = ? AND week_day = ? AND month_day = ? AND month = ? AND year = ?";
            statement = getNoteStatement(query, diaryId, title, text, weekDay, monthDay, month, year);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("note_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeStatement(statement);
        }

        return 0;
    }

    private static PreparedStatement getNoteStatement(String query, int diaryId, String title, String text, String weekDay, int monthDay, String month, int year) {
        PreparedStatement statement;
        try {
            statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, diaryId);
            statement.setString(2, title);
            statement.setString(3, text);
            statement.setString(4, weekDay);
            statement.setInt(5, monthDay);
            statement.setString(6, month);
            statement.setInt(7, year);
            return statement;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
