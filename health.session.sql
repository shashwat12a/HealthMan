-- CREATE DATABASE health;

USE health;

-- --------------------------------------------------------
-- Table: Users
-- Description: Stores general information for all users (admins, doctors, and patients).
-- --------------------------------------------------------


CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL, 
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM('Admin', 'Doctor', 'Patient') NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone_number VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- --------------------------------------------------------
-- Table: Doctors
-- Description: Stores specific information about doctors (specialty, qualifications).
-- --------------------------------------------------------

CREATE TABLE Doctors (
    doctor_id INT PRIMARY KEY,
    specialty VARCHAR(100),
    qualifications TEXT,
    FOREIGN KEY (doctor_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- --------------------------------------------------------
-- Table: Patients
-- Description: Stores specific information about patients (date of birth, gender, address).
-- --------------------------------------------------------


CREATE TABLE Patients (
    patient_id INT PRIMARY KEY,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    address TEXT,
    FOREIGN KEY (patient_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- --------------------------------------------------------
-- Table: Appointments
-- Description: Stores appointment details (patient, doctor, date, status).
-- --------------------------------------------------------

CREATE TABLE Appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATETIME,
    status ENUM('Scheduled', 'Rescheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctors(doctor_id)
);

-- --------------------------------------------------------
-- Table: Appointment_Booking
-- Description: Maps patients to appointments, representing bookings.
-- --------------------------------------------------------

CREATE TABLE Appointment_Booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    appointment_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patients(patient_id),
    FOREIGN KEY (appointment_id) REFERENCES Appointments(appointment_id)
);