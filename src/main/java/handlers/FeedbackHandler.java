package handlers;

import hidden.Constants;

import java.sql.*;

public class FeedbackHandler extends Constants{

    public void saveFeedback(String name, String city, String message) {
        try {
            String query = "INSERT INTO " + FEEDBACK_TABLE + " (" + FEEDBACK_NAME + ", " + FEEDBACK_CITY + ", " + FEEDBACK_MESSAGE + ") VALUES (?, ?, ?)";
            System.out.println(name + " " + city + " " + message);
            PreparedStatement statement = DatabaseHandler.getInstance().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, city);
            statement.setString(3, message);
            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
