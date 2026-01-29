package com.deepakLearning.HMS.repository;

import com.deepakLearning.HMS.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}