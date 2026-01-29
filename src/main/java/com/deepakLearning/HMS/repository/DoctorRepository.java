package com.deepakLearning.HMS.repository;

import com.deepakLearning.HMS.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}