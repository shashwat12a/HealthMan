package com.health.model;

public class Doctor {
    Integer doctor_id;
    String specialty;
    String qualifications;

    public Doctor() {
    }

    public Doctor(Integer doctor_id, String specialty, String qualifications) {
        this.doctor_id = doctor_id;
        this.specialty = specialty;
        this.qualifications = qualifications;
    }

    public Integer getDoctor_id() {
        return this.doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getQualifications() {
        return this.qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "{" +
            " doctor_id='" + getDoctor_id() + "'" +
            ", specialty='" + getSpecialty() + "'" +
            ", qualifications='" + getQualifications() + "'" +
            "}";
    }

}
