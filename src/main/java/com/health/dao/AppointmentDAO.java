package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.Appointment;

/**
 * AppointmentDAO handles CRUD operations specifically for the Appointments table.
 * It includes methods to add, retrieve, update, and delete appointment records.
 */

public class AppointmentDAO {
    /**
     * Adds a new appointment to the Appointments table.
     * @param patientId The ID of the patient who is booking the appointment.
     * @param doctorId The ID of the doctor who will see the patient.
     * @param appointmentDate The date and time of the appointment.
     * @param status The status of the appointment (e.g., "Scheduled", "Completed").
     * @return true if the appointment was added successfully, false otherwise.
     */
    public boolean scheduleAppointment(int patientId, int doctorId, Timestamp appointmentDate) {
        String query = "INSERT INTO Appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, 'Scheduled')";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setTimestamp(3, appointmentDate);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Retrieves an appointment by its appointment_id from the Appointments table.
     * @param appointmentId The unique ID of the appointment.
     * @return The Appointment object if found, null otherwise.
     */
    public Appointment getAppointmentById(int appointmentId) {
        String query = "SELECT * FROM Appointments WHERE appointment_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointmentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointment_id(rs.getInt("appointment_id"));
                appointment.setPatient_id(rs.getInt("patient_id"));
                appointment.setDoctor_id(rs.getInt("doctor_id"));
                appointment.setAppointment_date(rs.getTimestamp("appointment_date"));
                appointment.setStatus(rs.getString("status"));
                return appointment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Updates an existing appointment in the Appointments table.
     * @param appointmentId The ID of the appointment to be updated.
     * @param status The new status for the appointment (e.g., "Rescheduled", "Completed").
     * @param appointmentDate The new date and time for the appointment.
     * @return true if the appointment was updated successfully, false otherwise.
     */
    public boolean rescheduleAppointment(int appointmentId, Timestamp newAppointmentDate) {
        String query = "UPDATE Appointments SET appointment_date = ?, status = 'Rescheduled' WHERE appointment_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, newAppointmentDate);
            stmt.setInt(2, appointmentId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Deletes an appointment from the Appointments table.
     * @param appointmentId The ID of the appointment to be deleted.
     * @return true if the appointment was deleted successfully, false otherwise.
     */
    public boolean cancelAppointment(int appointmentId) {
        String query = "DELETE FROM Appointments WHERE appointment_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointmentId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

