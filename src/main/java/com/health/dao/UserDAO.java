package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.User;

/**
 * UserDAO handles all CRUD operations for the Users table.
 * It includes methods to add, get, update, and delete users.
 */

public class UserDAO {

    /**
     * Adds a new user to the Users table.
     * @param username The user's username.
     * @param password The user's password (hashed).
     * @param email The user's email.
     * @param role The user's role (Admin, Doctor, Patient).
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param phoneNumber The user's phone number.
     * @return true if the user was added successfully, false otherwise.
     */

    public boolean addUser(String username, String password, String email, String role, String firstName, String lastName, String phoneNumber) {
        String query = "INSERT INTO Users (username, password, email, role, first_name, last_name, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);  // Make sure to hash the password
            stmt.setString(3, email);
            stmt.setString(4, role);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
            stmt.setString(7, phoneNumber);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a user by their user_id from the Users table.
     * @param userId The user's unique ID.
     * @return The User object if found, null otherwise.
     */

    public User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setPhone_number(rs.getString("phone_number"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates user details in the Users table.
     * @param userId The user's unique ID.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param phoneNumber The user's phone number.
     * @return true if the user was updated successfully, false otherwise.
     */

    public boolean updateUser(int userId, String username, String email, String firstName, String lastName, String phoneNumber) {
        String query = "UPDATE Users SET username = ?, email = ?, first_name = ?, last_name = ?, phone_number = ? WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, firstName);
            stmt.setString(4, lastName);
            stmt.setString(5, phoneNumber);
            stmt.setInt(6, userId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a user from the Users table.
     * @param userId The user's unique ID.
     * @return true if the user was deleted successfully, false otherwise.
     */

    public boolean deleteUser(int userId) {
        String query = "DELETE FROM Users WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

