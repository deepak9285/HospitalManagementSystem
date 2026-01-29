package com.deepakLearning.HMS.repository;

import com.deepakLearning.HMS.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}