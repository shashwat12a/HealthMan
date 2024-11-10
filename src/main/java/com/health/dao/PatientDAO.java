package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.Patient;


public class PatientDAO {

    public boolean addPatient(int userId, Date dateOfBirth, String gender, String address) {
        String query = "INSERT INTO Patients (patient_id, date_of_birth, gender, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setDate(2, dateOfBirth);
            stmt.setString(3, gender);
            stmt.setString(4, address);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Patient getPatientById(int patientId) {
        String query = "SELECT * FROM Patients WHERE patient_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient();
                patient.setPatient_id(rs.getInt("patient_id"));
                patient.setDate_of_birth(rs.getDate("date_of_birth"));
                patient.setGender(rs.getString("gender"));
                patient.setAddress(rs.getString("address"));
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updatePatient(int patientId, Date dateOfBirth, String gender, String address) {
        String query = "UPDATE Patients SET date_of_birth = ?, gender = ?, address = ? WHERE patient_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, dateOfBirth);
            stmt.setString(2, gender);
            stmt.setString(3, address);
            stmt.setInt(4, patientId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePatient(int patientId) {
        String query = "DELETE FROM Patients WHERE patient_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

