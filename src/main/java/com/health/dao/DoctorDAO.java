package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.Doctor;

/**
 * DoctorDAO handles CRUD operations specifically for the Doctors table.
 * It includes methods for adding, retrieving, updating, and deleting doctor records.
 */

public class DoctorDAO {

    /**
     * Adds a new doctor to the Doctors table.
     * @param userId The unique ID of the doctor (from the Users table).
     * @param specialty The doctor's specialty (e.g., Cardiology).
     * @param qualifications The doctor's qualifications (e.g., MD, PhD).
     * @return true if the doctor was added successfully, false otherwise.
     */

    public boolean addDoctor(int userId, String specialty, String qualifications) {
        String query = "INSERT INTO Doctors (doctor_id, specialty, qualifications) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, specialty);
            stmt.setString(3, qualifications);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Retrieves a doctor by their doctor_id from the Doctors table.
     * @param doctorId The unique ID of the doctor.
     * @return The Doctor object if found, null otherwise.
     */
    public Doctor getDoctorById(int doctorId) {
        String query = "SELECT * FROM Doctors WHERE doctor_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctor_id(rs.getInt("doctor_id"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setQualifications(rs.getString("qualifications"));
                return doctor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Updates doctor details in the Doctors table.
     * @param doctorId The unique ID of the doctor.
     * @param specialty The doctor's specialty.
     * @param qualifications The doctor's qualifications.
     * @return true if the doctor was updated successfully, false otherwise.
     */
    public boolean updateDoctor(int doctorId, String specialty, String qualifications) {
        String query = "UPDATE Doctors SET specialty = ?, qualifications = ? WHERE doctor_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, specialty);
            stmt.setString(2, qualifications);
            stmt.setInt(3, doctorId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Deletes a doctor from the Doctors table.
     * @param doctorId The unique ID of the doctor.
     * @return true if the doctor was deleted successfully, false otherwise.
     */
    public boolean deleteDoctor(int doctorId) {
        String query = "DELETE FROM Doctors WHERE doctor_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, doctorId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
