package com.health.dao;

import java.sql.*;
import com.health.util.DBUtil;
import com.health.model.AppointmentBooking;

public class AppointmentBookingDAO {

    public boolean bookAppointment(int patientId, int appointmentId) {
        String query = "INSERT INTO Appointment_Booking (patient_id, appointment_id) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, appointmentId);

            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AppointmentBooking getBookingById(int bookingId) {
        String query = "SELECT * FROM Appointment_Booking WHERE booking_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AppointmentBooking booking = new AppointmentBooking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setPatientId(rs.getInt("patient_id"));
                booking.setAppointmentId(rs.getInt("appointment_id"));
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean cancelBooking(int bookingId) {
        String query = "DELETE FROM Appointment_Booking WHERE booking_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookingId);
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
