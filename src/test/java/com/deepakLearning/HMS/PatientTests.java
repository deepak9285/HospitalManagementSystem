package com.deepakLearning.HMS;

import com.deepakLearning.HMS.entity.patient;
import com.deepakLearning.HMS.repository.patientRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private patientRepository patientrepository;

    @Test
    public void testPatientRepository(){
        List<patient> patientList=patientrepository.findAll();
        System.out.println(patientList);
    }
}
