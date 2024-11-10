package com.health.model;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class Appointment {
    Integer appointment_id;
    Integer patient_id;
    Integer doctor_id;
    Timestamp appointment_date;
    String status;
    Date created_at;


    public Appointment() {
    }

    public Appointment(Integer appointment_id, Integer patient_id, Integer doctor_id, Timestamp appointment_date, String status, Date created_at) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.appointment_date = appointment_date;
        this.status = status;
        this.created_at = created_at;
    }

    public Integer getAppointment_id() {
        return this.appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Integer getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getDoctor_id() {
        return this.doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Timestamp getAppointment_date() {
        return this.appointment_date;
    }

    public void setAppointment_date(Timestamp appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "{" +
            " appointment_id='" + getAppointment_id() + "'" +
            ", patient_id='" + getPatient_id() + "'" +
            ", doctor_id='" + getDoctor_id() + "'" +
            ", appointment_date='" + getAppointment_date() + "'" +
            ", status='" + getStatus() + "'" +
            ", created_at='" + getCreated_at() + "'" +
            "}";
    }

}
