package com.health.model;

import java.util.Date;

/**
 * Patient class represents a patient in the healthcare system.
 * It holds information about the patient's personal details, contact info, and health data.
 */

public class Patient {
    Integer patient_id;
    Date date_of_birth;
    String gender;
    String address;

    public Patient() {
    }

    public Patient(Integer patient_id, Date date_of_birth, String gender, String address) {
        this.patient_id = patient_id;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
    }

    public Integer getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate_of_birth() {
        return this.date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
            " patient_id='" + getPatient_id() + "'" +
            ", date_of_birth='" + getDate_of_birth() + "'" +
            ", gender='" + getGender() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }

}
