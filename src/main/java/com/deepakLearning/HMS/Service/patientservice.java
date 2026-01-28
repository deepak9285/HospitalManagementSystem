package com.deepakLearning.HMS.Service;

import com.deepakLearning.HMS.entity.patient;
import com.deepakLearning.HMS.repository.patientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class patientservice {
    private final patientRepository pr;

    public patientservice(patientRepository pr) {
        this.pr = pr;
    }
    public patient getPatientById(Long id){
        patient p1=pr.findById(id).orElseThrow();
        patient p2=pr.findById(id).orElseThrow();

        return p1;
    }
}
