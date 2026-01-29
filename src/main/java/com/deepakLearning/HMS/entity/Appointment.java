package com.deepakLearning.HMS.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalDateTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public patient getPatient() {
        return p;
    }

    public void setPatient(patient patient) {
        this.p = patient;
    }

    public Appointment(Long id, LocalDateTime appointment_time, String reason, Doctor doctor, patient patient) {
        this.id = id;
        this.appointment_time = appointment_time;
        this.reason = reason;
        this.doctor = doctor;
        this.p = patient;
    }

    @CreationTimestamp
    private LocalDateTime appointment_time;


    private String reason;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private patient p;
}
