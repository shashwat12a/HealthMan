package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.Doctor;

public class DoctorDAO {

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
