package com.deepakLearning.HMS.repository;

import com.deepakLearning.HMS.dto.BloodGroupCountResponseEntity;
import com.deepakLearning.HMS.entity.patient;
import com.deepakLearning.HMS.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface patientRepository extends JpaRepository<patient,Long> {
    patient findByName(String name);
    List<patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<patient> findByBirthDateBetween(LocalDate startDate,LocalDate endDate);
    List<patient> findByNameContainingOrderByIdDesc(String query);

    @Query("Select p from patient p where p.bloodGroup=?1")
    List<patient>findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("Select p from patient p where p.birthDate >:birthDate")
    List<patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("Select new com.deepakLearning.HMS.dto.BloodGroupCountResponseEntity(p.bloodGroup, Count(p)) from patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "Select * from patient",nativeQuery = true)
    Page<patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("Update patient p set p.name=:name where p.id=:id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);


}
