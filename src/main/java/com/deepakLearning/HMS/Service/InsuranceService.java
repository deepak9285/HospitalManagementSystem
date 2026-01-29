package com.deepakLearning.HMS.Service;

import com.deepakLearning.HMS.entity.Insurance;
import com.deepakLearning.HMS.entity.patient;
import com.deepakLearning.HMS.repository.InsuranceRepository;
import com.deepakLearning.HMS.repository.patientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InsuranceService {
    private InsuranceRepository insuranceRepository;
    private patientRepository prepository;

    @Transactional
    public patient assignInsurance(Insurance insurance, Long patientId){
        patient pt=prepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("Patient not found with id:"+ patientId));
        pt.setInsurance(insurance);

        insurance.setP(pt);//bidirectional consistency maintainence

        return pt;

    }
}
