package com.health.model;

/**
 * AppointmentBooking represents the booking of an appointment by a patient.
 * It links a patient to a specific appointment through their unique patient_id and appointment_id.
 */

public class AppointmentBooking {
    private int bookingId;
    private int patientId;
    private int appointmentId;

    // Getters and setters
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
}
