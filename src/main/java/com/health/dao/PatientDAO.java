package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.Patient;

/**
 * PatientDAO handles CRUD operations for the Patients table.
 * It includes methods to add, retrieve, update, and delete patient records.
 */

public class PatientDAO {

    /**
     * Adds a new patient to the Patients table.
     * This method creates a new patient record in the database.
     * @param userId The unique ID of the user (Patient) from the Users table.
     * @param address The patient's address.
     * @param dateOfBirth The patient's date of birth.
     * @param gender The patient's gender (e.g., "Male", "Female").
     * @return true if the patient was added successfully, false otherwise.
     */

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

        /**
     * Retrieves a patient by their patient_id from the Patients table.
     * This method fetches the details of a specific patient.
     * @param patientId The unique ID of the patient.
     * @return The Patient object containing the patient's details, or null if not found.
     */

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

     /**
     * Updates the patient's information in the Patients table.
     * This method allows updating the patient's address, date of birth, and gender.
     * @param patientId The unique ID of the patient.
     * @param address The new address for the patient.
     * @param dateOfBirth The new date of birth for the patient.
     * @param gender The new gender for the patient.
     * @return true if the patient details were updated successfully, false otherwise.
     */

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
 /**
     * Deletes a patient from the Patients table.
     * This method removes a patient's record from the database.
     * @param patientId The unique ID of the patient to be deleted.
     * @return true if the patient was deleted successfully, false otherwise.
     */
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

